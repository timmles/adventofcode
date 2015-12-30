package day8

import common.Common
import org.apache.commons.lang3.StringEscapeUtils

fun main(args: Array<String>) {
        val dayEightInput = Common.getFile("day8_input.txt")

    var countCode = 0;
    var countText = 0
    dayEightInput.forEachLine {
        println("input: " + it)

        val countCode1 = ListCounter.countCode(it)
        val countText1 = ListCounter.countText(it)

        println("Code: " + countCode1)
        println("Text: " + countText1)

        countCode += countCode1
        countText += countText1
    }

    println(countCode)
    println(countText)
    println(countCode - countText)
}

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

//    private fun parseText(input: String): String {
//        var parsedInput = input
//
//        return StringEscapeUtils.unescapeJava(input).length
//    }
}