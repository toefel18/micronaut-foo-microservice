package micronaut.foo.microservice

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import micronaut.foo.microservice.dto.LoyaltyOverview
import micronaut.foo.microservice.dto.User
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import javax.inject.Inject

@Controller("/loyalty")
class LoyaltyController {

    @Inject
    lateinit var overviewService: OverviewService

    @Inject
    lateinit var placeholderClient: PlaceholderClient

    @Get("/")
    fun loyaltyOverview(): LoyaltyOverview {
        return overviewService.createOverview()
    }

    @Get("/mono")
    fun loyaltyOverviewMono(): Mono<LoyaltyOverview> {
        return Mono.just(overviewService.createOverview())
    }

    @Get("/users")
    fun listUsers(): List<User> {
        return placeholderClient.fetchUsers()
    }

    @Get("/users-mono")
    fun listUsersMono(): Mono<List<User>> {
        // schedule long-running task on other thread-pool using subscribeOn
        return Mono.fromCallable {  placeholderClient.fetchUsers() }.subscribeOn(Schedulers.elastic())
    }
}
