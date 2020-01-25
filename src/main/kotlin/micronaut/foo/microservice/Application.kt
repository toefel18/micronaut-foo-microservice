package micronaut.foo.microservice

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

// exposed on http://localhost:8080/swagger/micronaut-foo-microservice-0.0.yml via config, meh
@OpenAPIDefinition(
    info = Info(
            title = "micronaut-foo-microservice",
            version = "0.0"
    )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("micronaut.foo.microservice")
                .mainClass(Application.javaClass)
                .start()
    }
}