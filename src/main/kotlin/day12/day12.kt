package day12

import common.Common
import java.io.StringReader
import javax.json.*
import javax.json.stream.JsonParser

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
        traverse(reader.readObject().entries)

        return count
    }

    fun traverse(entries: MutableSet<MutableMap.MutableEntry<String, JsonValue>>) {
        entries.forEach {
            when(it.value) {
                is JsonObject-> traverse((it.value as JsonObject).entries)
                is JsonNumber -> count += (it.value as JsonNumber).intValue()
            }
        }
    }
}