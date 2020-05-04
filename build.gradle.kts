plugins {
    java
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

    dependencies{
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.6.RELEASE")
    implementation(project(":services"))
    implementation(project(":security"))
}
