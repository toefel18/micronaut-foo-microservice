package micronaut.foo.microservice

import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import micronaut.foo.microservice.dto.LoyaltyOverview
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class LoyaltyControllerTest {
    @Inject
    lateinit var embeddedServer: EmbeddedServer

    @Test
    fun testGetLoyaltyOverview() {
//        val overview = client.toBlocking().retrieve<LoyaltyOverview>("/loyalty", LoyaltyOverview::class.java)
//        assertThat(overview!!.points).isEqualTo(200)
        embeddedServer.applicationContext.createBean(RxHttpClient::class.java, embeddedServer.url).use { client ->
            val overview = client.toBlocking().retrieve("/loyalty", LoyaltyOverview::class.java)
            assertThat(overview.points).isEqualTo(200)
        }
    }

}