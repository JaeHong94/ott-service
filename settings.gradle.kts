rootProject.name = "ott-service"

include("ott-service-adapters")
include("ott-service-adapters:adapter-http")
include("ott-service-adapters:adapter-persistence")
include("ott-service-adapters:adapter-redis")

include("ott-service-apps")
include("ott-service-apps:app-api")
include("ott-service-apps:app-batch")

include("ott-service-commons")

include("ott-service-core")
include("ott-service-core:core-domain")
include("ott-service-core:core-port")
include("ott-service-core:core-service")
include("ott-service-core:core-usecase")

