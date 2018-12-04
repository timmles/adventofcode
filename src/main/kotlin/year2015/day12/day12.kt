package year2015.day12

import common.Common
import java.io.StringReader
import javax.json.*

fun main(args: Array<String>) {
    val dayEightInput = Common.getFile("day12_input.txt")

    dayEightInput.forEachLine {
        println(Abacus(it).parse())
    }

}

class Abacus (json: String) {
    val reader: JsonReader
    var count: Int = 0

    init {
        reader = Json.createReader(StringReader(json))
    }

    fun parse(): Int {
        reader.readObject().entries.forEach {
            traverse(it.value)
        }

        return count
    }

    fun traverse(value: JsonValue) {
        when(value) {
            is JsonObject -> value.entries.forEach { traverse(it.value) }
            is JsonArray -> value.forEach { traverse(it) }
            is JsonNumber -> count += value.intValue()
        }
    }
}