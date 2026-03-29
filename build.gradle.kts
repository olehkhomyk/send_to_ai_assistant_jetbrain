plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.3.0"
}

group = "com.github.sendtoai"
version = "1.0.0"

val pluginId = "com.github.sendtoai"
val pluginName = "Send to AI Assistant"
val pluginVersion = project.version.toString()
val platformVersion = providers.gradleProperty("platformVersion").orElse("2025.3.3")
val pluginSinceBuild = providers.gradleProperty("pluginSinceBuild").orElse("253")

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        webstorm(platformVersion.get())
        bundledPlugin("JavaScript")
    }
}

intellijPlatform {
    pluginConfiguration {
        id = pluginId
        name = pluginName
        version = pluginVersion
        description = """
            <p>Send selected code to JetBrains AI Assistant with file and line context.</p>
            <p>The action opens the AI Assistant tool window and inserts a compact file reference into the chat input without sending the message automatically.</p>
        """.trimIndent()
        changeNotes = """
            <p>Initial public release.</p>
            <ul>
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
