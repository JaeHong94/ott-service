dependencies {
    implementation(project(":ott-service-core:core-usecase"))
    implementation(project(":ott-service-core:core-port"))

    runtimeOnly(project(":ott-service-adapters:adapter-http"))

    implementation("org.springframework:spring-context")
}