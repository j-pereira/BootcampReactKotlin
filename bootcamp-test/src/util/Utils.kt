package util

import org.w3c.dom.events.Event

val Event.value: String
    get() = this.currentTarget.asDynamic().value as String



private val enUSLanguage = mapOf(
        "todos" to "todos",
        "What needs to be done?" to "What needs to be done?"
)


fun String.translate(): String {
    return enUSLanguage[this] ?: "***$this"

}