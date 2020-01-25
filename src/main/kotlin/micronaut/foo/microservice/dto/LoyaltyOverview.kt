package micronaut.foo.microservice.dto

import java.time.LocalDate
import java.time.LocalDateTime

data class LoyaltyOverview(
    val points: Int,
    val date: LocalDate,
    val entries: List<LogEntry>
)

data class LogEntry(
    val ts: LocalDateTime,
    val amount: Int,
    val description: String
)