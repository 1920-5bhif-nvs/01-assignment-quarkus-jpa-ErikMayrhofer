# Erik Mayrhofer
Written in Kotlin, because I like Kotlin and it's easy with quarkus.

Uses a H2-In-Memory DB because it's quick to setup and enough for 
this demo.
## Paths

### `http://localhost:8080/todo`
 * `GET`: List of all Todos
 * `PUT`: Update Todo
 * `POST`: Create Todo
 * `DELETE`: Delete Todo
 
Put, Post and Delete take a json-body:
```json
{
    "id": 1,
    "status": "PENDING",
    "text": "TestTodo"
}
```

### `http://localhost:8080/todo/{id}`
 * `DELETE`: Deletes TODO with given id.