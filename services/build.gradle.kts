dependencies {
    implementation(project(":data"))
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.2.6.RELEASE")

    annotationProcessor("org.mapstruct:mapstruct-processor:1.3.1.Final")
    compileOnly("org.mapstruct:mapstruct:1.3.1.Final")

    annotationProcessor("org.projectlombok:lombok:1.18.12")
    compileOnly("org.projectlombok:lombok:1.18.12")

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.11.0")
}
