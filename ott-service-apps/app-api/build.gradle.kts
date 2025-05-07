dependencies {
    implementation(project(":ott-service-core:core-usecase"))
    implementation(project(":ott-service-commons"))

    runtimeOnly(project(":ott-service-core:core-service"))

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-app")
    implementation("org.springframework.boot:spring-boot-starter-validation")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//    implementation("org.springframework.security:spring-security-oauth2-client")
    implementation("org.springframework.data:spring-data-commons")


    implementation("org.springframework.boot:spring-boot-starter-web")
}

val appMainClassName = "com.jaehong.ottservice.OttServiceApplication"
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    mainClass.set(appMainClassName)
    archiveClassifier.set("boot")
}