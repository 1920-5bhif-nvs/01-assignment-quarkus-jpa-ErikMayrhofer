package at.htl.rest.dao

import at.htl.rest.model.TodoEntry
import at.htl.rest.model.TodoStatus
import javax.annotation.PostConstruct
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.transaction.Transactional

@ApplicationScoped
open class TodoEntryDao {

    @Inject
    open lateinit var em: EntityManager

    @Transactional
    open fun create(entry: TodoEntry): TodoEntry{
        em.contains(entry)
        em.persist(entry)
        return entry
    }

    open fun markAsDone(id: Long){
        val entry = em.find(TodoEntry::class.java, id)
        entry.status = TodoStatus.DONE
        em.persist(entry);
    }

    open fun getAll(): List<TodoEntry> {
        val query = em.createNamedQuery("todoEntry.findAll", TodoEntry::class.java)
        return query.resultList
    }

    @Transactional
    open fun update(entry: TodoEntry): TodoEntry {
        val inserted = em.merge(entry);
        return inserted
    }

    @PostConstruct
    @Transactional
    open fun initDb(){
        em.persist(TodoEntry().apply { text="TestTodo"; status=TodoStatus.PENDING })
        em.persist(TodoEntry().apply { text="TestTodo2"; status=TodoStatus.PENDING })
    }
}
