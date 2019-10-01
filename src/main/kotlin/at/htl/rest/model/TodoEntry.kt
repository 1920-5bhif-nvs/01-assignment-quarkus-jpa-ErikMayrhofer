package at.htl.rest.model

import javax.persistence.*


enum class TodoStatus {
    PENDING,
    IN_PROGRESS,
    DONE
}

@Entity
@NamedQuery(name = "todoEntry.findAll", query = "select n from TodoEntry n")
open class TodoEntry()
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    open lateinit var text: String

    @Enumerated(EnumType.STRING)
    open lateinit var status: TodoStatus
}
