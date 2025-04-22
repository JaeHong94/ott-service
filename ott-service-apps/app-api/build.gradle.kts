dependencies {
    implementation(project(":ott-service-core:core-usecase"))

    runtimeOnly(project(":ott-service-core:core-service"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}