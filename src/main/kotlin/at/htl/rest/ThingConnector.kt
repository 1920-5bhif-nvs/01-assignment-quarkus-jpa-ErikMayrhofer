package at.htl.rest

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.persistence.*
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@ApplicationScoped
open class ThingConnector {

    @Transactional
    open fun createAndGet(em: EntityManager): List<Thing> {
        val thing = Thing().apply { name = "Yeet" }
        em.persist(thing)
        val things = em.createNamedQuery("thing.findAll", Thing::class.java)
        return things.resultList
    }
}


@Entity
@NamedQuery(name = "thing.findAll", query = "select n from Thing n")
public open class Thing()
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="giftSeq")
    var id: Long? = null
    lateinit var name: String
}