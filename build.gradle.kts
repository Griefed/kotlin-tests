plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "de.griefed"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.formdev:flatlaf:3.0")
    implementation("com.formdev:flatlaf-extras:3.0")
    implementation("com.formdev:flatlaf-intellij-themes:3.0")
    implementation("com.formdev:flatlaf-fonts-inter:3.19")
    implementation("com.formdev:flatlaf-fonts-roboto:2.137")
    implementation("com.formdev:flatlaf-fonts-roboto-mono:3.000")
    implementation("com.formdev:flatlaf-fonts-jetbrains-mono:2.242")
    implementation("com.miglayout:miglayout-swing:11.0")
    implementation("com.miglayout:miglayout-swt:11.0")
    implementation("de.griefed:larsonscanner:1.0.4")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}