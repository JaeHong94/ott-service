dependencies {
    implementation(project(":ott-service-core:core-usecase"))
    implementation(project(":ott-service-core:core-port"))

    runtimeOnly(project(":ott-service-adapters:adapter-http"))
    runtimeOnly(project(":ott-service-adapters:adapter-persistence"))
    runtimeOnly(project(":ott-service-adapters:adapter-redis"))

    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-commons")
}