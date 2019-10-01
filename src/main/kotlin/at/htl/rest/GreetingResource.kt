package at.htl.rest

import javax.inject.Inject
import javax.persistence.*
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/greeting")
class GreetingResource {

    @Inject
    lateinit var entityManager: EntityManager

    @Inject
    lateinit var tc: ThingConnector

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "hello"

    @GET
    @Path("/abc")
    @Produces(MediaType.APPLICATION_JSON)
    fun data(): List<Thing> {
        return tc.createAndGet(entityManager)
    }
}
