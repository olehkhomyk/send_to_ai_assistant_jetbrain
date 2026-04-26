plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.3.0"
}

group = "com.github.sendtoai"
version = "1.1.0"

val pluginId = "com.github.sendtoai"
val pluginName = "Send to AI Assistant"
val pluginVersion = project.version.toString()
val platformVersion = providers.gradleProperty("platformVersion").orElse("2025.2.6.1")
val pluginSinceBuild = providers.gradleProperty("pluginSinceBuild").orElse("252")

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity(platformVersion.get())
    }
}

intellijPlatform {
    pluginConfiguration {
        id = pluginId
        name = pluginName
        version = pluginVersion
        description = """
            <p>Quickly send selected code to the <b>JetBrains AI Assistant</b> chat — with the filename and line numbers already included, so you don't have to copy-paste and explain where the code came from.</p>

            <h2>How it works</h2>
            <ol>
              <li>Select any code in the editor.</li>
              <li>Press <b>Alt+Shift+A</b> (or right-click → <b>Send to AI Assistant Chat</b>).</li>
              <li>The AI Assistant panel opens and the chat input is pre-filled with a reference like:<br/>
                  <code>@file:UserService.kt [lines 42 to 58]</code>
              </li>
              <li>Type your question and press Enter — the AI already knows exactly what code you mean.</li>
            </ol>
            <p>The message is <b>inserted but not sent automatically</b>, so you always have a chance to add context before submitting.</p>

            <h2>Default shortcut</h2>
            <ul>
              <li><b>macOS:</b> ⌥⇧A (Option + Shift + A)</li>
              <li><b>Windows / Linux:</b> Alt + Shift + A</li>
            </ul>

            <h2>How to change the shortcut</h2>
            <ol>
              <li>Open <b>Settings</b> (Ctrl+Alt+S / ⌘,).</li>
              <li>Go to <b>Keymap</b>.</li>
              <li>Search for <b>Send to AI Assistant Chat</b>.</li>
              <li>Double-click the action → <b>Add Keyboard Shortcut</b> → press your preferred key combination → OK.</li>
            </ol>

            <h2>Requirements</h2>
            <ul>
              <li>The <b>JetBrains AI Assistant</b> plugin must be installed and enabled.</li>
              <li>Compatible with all JetBrains IDEs: IntelliJ IDEA (Community &amp; Ultimate), PyCharm, WebStorm, PhpStorm, GoLand, CLion, Rider, RubyMine, RustRover, DataGrip, Android Studio.</li>
            </ul>
        """.trimIndent()
        changeNotes = """
            <p>1.1.0</p>
            <ul>
              <li>Broadened compatibility to all JetBrains IDEs with AI Assistant installed.</li>
              <li>Switched build target to IntelliJ IDEA Community SDK — works in IDEA, PyCharm, WebStorm, GoLand, PhpStorm, CLion, Rider, RustRover, RubyMine, DataGrip, Android Studio.</li>
              <li>Removed JavaScript plugin dependency that caused AI Assistant to be disabled after restart.</li>
            </ul>
            <p>1.0.0</p>
            <ul>
              <li>Initial public release.</li>
              <li>Add editor action and shortcut for sending selected code to AI Assistant.</li>
              <li>Include file name and line range in the generated prompt.</li>
            </ul>
        """.trimIndent()
        ideaVersion {
            sinceBuild = pluginSinceBuild.get()
        }
        vendor {
            name = "Oleh Khomyk"
            email = "oleh.khomyk@gmail.com"
        }
    }
    instrumentCode = false
    buildSearchableOptions = false
}

kotlin {
    jvmToolchain(21)
}
