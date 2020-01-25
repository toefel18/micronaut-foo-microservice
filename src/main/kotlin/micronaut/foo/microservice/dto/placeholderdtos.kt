package micronaut.foo.microservice.dto

// {
//    "id": 1,
//    "name": "Leanne Graham",
//    "username": "Bret",
//    "email": "Sincere@april.biz",
//    "address": {
//      "street": "Kulas Light",
//      "suite": "Apt. 556",
//      "city": "Gwenborough",
//      "zipcode": "92998-3874",
//      "geo": {
//        "lat": "-37.3159",
//        "lng": "81.1496"
//      }
//    },
//    "phone": "1-770-736-8031 x56442",
//    "website": "hildegard.org",
//    "company": {
//      "name": "Romaguera-Crona",
//      "catchPhrase": "Multi-layered client-server neural-net",
//      "bs": "harness real-time e-markets"
//    }
//  }


data class User (

    val id : Int,
    val name : String,
    val username : String,
    val email : String,
    val address : Address,
    val phone : String,
    val website : String,
    val company : Company
)

data class Address (

    val street : String,
    val suite : String,
    val city : String,
    val zipcode : String,
    val geo : Geo
)


data class Company (

    val name : String,
    val catchPhrase : String,
    val bs : String
)

data class Geo (

    val lat : Double,
    val lng : Double
)