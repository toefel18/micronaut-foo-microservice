package micronaut.foo.microservice

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import io.reactivex.Maybe
import micronaut.foo.microservice.dto.User
import javax.annotation.Generated

@Client("https://jsonplaceholder.typicode.com")
interface PlaceholderClient {
    @Get("/users")
    fun fetchUsers(): List<User>;
}