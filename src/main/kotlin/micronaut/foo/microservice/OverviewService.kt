package micronaut.foo.microservice

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import micronaut.foo.microservice.dto.LogEntry
import micronaut.foo.microservice.dto.LoyaltyOverview
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Singleton

@Singleton
class OverviewService {
    fun createOverview(): LoyaltyOverview {
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