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
