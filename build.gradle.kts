plugins {
    kotlin("jvm") version "1.6.0"
}

repositories {
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine")
    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin", "kotlin-test-junit5")
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src/main/kotlin")
        }
    }

    wrapper {
        gradleVersion = "7.3"
    }

    withType<Test> {
        useJUnitPlatform {
            includeEngines("junit-jupiter")
        }
    }
}
