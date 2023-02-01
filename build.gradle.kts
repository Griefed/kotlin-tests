import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
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

    implementation("org.apache.logging.log4j:log4j-api-kotlin:1.2.0")
    implementation("org.apache.logging.log4j:log4j-core:2.19.0")
    implementation("com.electronwill.night-config:toml:3.6.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0")

    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "17"
}