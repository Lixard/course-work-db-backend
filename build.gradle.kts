import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "2.2.5.RELEASE"
}

allprojects {

    apply {
        plugin("java")
    }

    group = "ru.student"
    version = "1.0"

    repositories {
        mavenCentral()
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_11
    }

    dependencies {
        implementation("ru.student:common:1.0")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.6.RELEASE")
    implementation("org.apache.directory.studio:org.apache.commons.io:2.4")
    implementation(project(":services"))
    implementation(project(":security"))

    annotationProcessor("org.projectlombok:lombok:1.18.12")
    compileOnly("org.projectlombok:lombok:1.18.12")
}

springBoot {
    mainClassName = "ru.student.backend.rest.App"
}

val bootJar: BootJar by tasks

bootJar.apply {
    launchScript()
}
