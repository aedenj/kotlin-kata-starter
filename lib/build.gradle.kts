import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    idea

    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.9.24"

    // https://plugins.gradle.org/plugin/com.adarshr.test-logger
    id("com.adarshr.test-logger") version "4.0.0"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    test {
        useJUnitPlatform()

        testlogger {
            theme = ThemeType.MOCHA
            slowThreshold = 5000
            showStandardStreams = true
            showFullStackTraces = false
            logLevel = LogLevel.QUIET
        }
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    val junitVersion = "5.10.2"
    val assertjVersion = "3.26.0"

    // Basics
    listOf(
        platform("org.jetbrains.kotlin:kotlin-bom"), // Align versions of all Kotlin components
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8",
        "com.google.guava:guava:30.1.1-jre"
    ).forEach { implementation(it) }


    // Testing
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    listOf(
        "org.jetbrains.kotlin:kotlin-test",
        "org.jetbrains.kotlin:kotlin-test-junit5",
        "org.junit.jupiter:junit-jupiter-params:$junitVersion",
        "org.assertj:assertj-core:$assertjVersion"
    ).forEach { testImplementation(it) }
}
