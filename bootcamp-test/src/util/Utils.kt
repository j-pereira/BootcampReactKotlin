package util

import org.w3c.dom.events.Event

val Event.value: String
    get() = this.currentTarget.asDynamic().value as String



private val enUSLanguage = mapOf(
        "Hello Bootcamp" to "Hello Bootcamp2"
)


fun String.translate(): String {
    return enUSLanguage[this] ?: "***$this"

}