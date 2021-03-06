dependencies {
    runtimeOnly("org.postgresql:postgresql:42.2.12")
    runtimeOnly("org.liquibase:liquibase-core:3.8.9")
    runtimeOnly("org.springframework:spring-jdbc:5.2.6.RELEASE")

    annotationProcessor("org.projectlombok:lombok:1.18.12")
    compileOnly("org.projectlombok:lombok:1.18.12")

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.2")
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.2.6.RELEASE")

    compileOnly("com.fasterxml.jackson.core:jackson-databind:2.10.3")
}
