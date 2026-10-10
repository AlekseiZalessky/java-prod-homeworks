plugins {
    application
    id("com.gradleup.shadow") version "9.6.1"
}

dependencies {
    implementation("com.google.guava:guava:33.4.0-jre")
}

application {
    mainClass.set("com.github.alekseizalessky.hw01.HelloOtus")
}