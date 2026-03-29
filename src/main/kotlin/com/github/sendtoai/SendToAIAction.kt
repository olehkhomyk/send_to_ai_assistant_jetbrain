package com.github.sendtoai

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.ui.EditorTextField
import com.intellij.util.ui.UIUtil
import javax.swing.JComponent

class SendToAIAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val editor: Editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val project = e.project ?: return

        // 1. Build message
        val fileName = e.getData(CommonDataKeys.VIRTUAL_FILE)?.name ?: "unknown"
        val message = if (editor.selectionModel.hasSelection()) {
            val doc = editor.document
            val startLine = doc.getLineNumber(editor.selectionModel.selectionStart) + 1
            val endLine = doc.getLineNumber(editor.selectionModel.selectionEnd) + 1
            val lineInfo = if (startLine == endLine) "[line $startLine]" else "[lines from $startLine to $endLine]"
            "@file:$fileName $lineInfo "
        } else {
            "@file:$fileName "
        }

        // 2. Find AI Assistant tool window
        val toolWindowManager = ToolWindowManager.getInstance(project)
        val toolWindow = listOf("AI Assistant", "AIAssistant", "AI Chat")
            .mapNotNull { toolWindowManager.getToolWindow(it) }
            .firstOrNull()

        if (toolWindow == null) return

        // 3. Activate (never toggles/closes) and paste in callback
        toolWindow.activate({
            insertIntoAiInput(toolWindow.component, message)
                ?: ApplicationManager.getApplication().invokeLater {
                    // one extra EDT cycle if UI wasn't ready yet
                    insertIntoAiInput(toolWindow.component, message)
                }
        }, true)
    }

    private fun insertIntoAiInput(root: java.awt.Component, message: String): Unit? {
        val field = UIUtil.findComponentOfType(root as? JComponent ?: return null, EditorTextField::class.java)
            ?: return null

        val existing = field.text.trimEnd()
        val newText = if (existing.isEmpty()) message else "$existing\n$message"
        field.setText(newText)
        field.requestFocus()
        field.editor?.caretModel?.moveToOffset(newText.length)
        return Unit
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.getData(CommonDataKeys.EDITOR) != null
    }
}
