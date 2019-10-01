package at.htl.rest

import at.htl.rest.dao.TodoEntryDao
import at.htl.rest.model.TodoEntry
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/todo")
class TodoEntryResource {

    @Inject
    lateinit var todos: TodoEntryDao

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun listAll(): List<TodoEntry>{
        return todos.getAll()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create(entry: TodoEntry): TodoEntry {
        return todos.create(entry)
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun update(entry: TodoEntry): TodoEntry{
        return todos.update(entry)
    }
}