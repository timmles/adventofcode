package year2015.day8

import org.apache.commons.lang3.StringEscapeUtils

object ListCounter {
    fun countCode(input: String): Int {
        return input.length
    }

    fun countText(input: String): Int {
        var trimmedInput = input.trim('"')
        trimmedInput = StringEscapeUtils.unescapeCsv(trimmedInput)
        trimmedInput = trimmedInput.replace("\\x", "\\u00")
        trimmedInput = StringEscapeUtils.unescapeJava(trimmedInput)

        println("trimmed: " + trimmedInput)

        return trimmedInput.length
    }

}
