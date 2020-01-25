package micronaut.foo.microservice

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import micronaut.foo.microservice.dto.LogEntry
import micronaut.foo.microservice.dto.LoyaltyOverview
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

@Controller("/loyalty")
class LoyaltyController {

    @Inject
    lateinit var placeholderClient: PlaceholderClient

    @Get("/")
    fun index(): LoyaltyOverview {
        val res = placeholderClient.fetchUsers()
        println(res)
        return LoyaltyOverview(
            points = 200,
            date = LocalDate.now(),
            entries = listOf(
                LogEntry(
                    ts = LocalDateTime.now(),
                    amount = 100,
                    description = "Boek bij"
                ),
                LogEntry(
                    ts = LocalDateTime.now(),
                    amount = 100,
                    description = "Boek bij 2"
                )
            )
        )
    }


}