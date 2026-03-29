plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.3.0"
}

group = "com.github.sendtoai"
version = "1.0.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        local("/Users/olehkhomyk/Applications/WebStorm.app")
    }
}

intellijPlatform {
    pluginConfiguration {
        name = "Send to AI Assistant"
        version = "1.0.0"
    }
    instrumentCode = false
    buildSearchableOptions = false
}

kotlin {
    jvmToolchain(21)
}
