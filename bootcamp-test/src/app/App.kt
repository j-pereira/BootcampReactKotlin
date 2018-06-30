package app

import kotlinx.html.js.onChangeFunction
import react.*
import react.dom.*
import logo.*
import ticker.*
import util.translate
import util.value

class App : RComponent<RProps, App.State>() {

    class State(var inputValue: String) : RState

    override fun componentWillMount() {
        setState {
            inputValue = "Input your name"
        }
    }

    override fun RBuilder.render() {
        h1 {
            + "Hello Bootcamp".translate()
        }

        div {

            input{
                attrs {
                    value = state.inputValue
                    onChangeFunction = { event ->
                        val value = event.value
                        setState {
                            inputValue = value
                        }
                    }
                }
            }
        }

        test(state.inputValue)

    }
}

fun RBuilder.app() = child(App::class) {}





class Test : RComponent<Test.Props, RState>() {

    class Props(var value: String) : RProps

    override fun RBuilder.render(){

        div {
            span {
                + props.value
            }
        }
    }
}

fun RBuilder.test(value: String) = child(Test::class) {
    attrs.value = value
}


