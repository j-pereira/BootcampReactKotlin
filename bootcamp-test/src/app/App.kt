package app


import model.Todo
import react.*
import react.dom.*


class App : RComponent<RProps, App.State>() {

    init {
        state.todos = loadTodos()
    }

    fun loadTodos(): List<Todo> {
        return listOf(

        )
    }

    fun createTodo(todo: Todo){
        val oldTodos = state.todos

        setState{
            todos = oldTodos + todo
        }
    }

    fun removeTodo(todo: Todo) {
        val oldTodos = state.todos

        setState{
            todos = oldTodos - todo
        }
    }

    fun updateTodo(todo: Todo) {
        val newTodo = state.todos.map { oldTodo ->
            if(todo.id == oldTodo.id) {
                todo
            }else {
                oldTodo
            }
        }
        setState {
            todos = newTodo
        }
    }

    override fun RBuilder.render() {
        section(classes = "todoapp") {
            headerInput(::createTodo)

            section(classes = "main") {
                todoList(state.todos, ::removeTodo, ::updateTodo)
            }

        }
    }

    class State(var todos: List<Todo>): RState


}

fun RBuilder.app() = child(App::class) {}


