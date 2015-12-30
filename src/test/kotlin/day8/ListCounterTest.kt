package day8

import common.Common
import org.apache.commons.lang3.StringEscapeUtils
import org.junit.Test
import kotlin.test.assertEquals

class ListCounterTest {
    @Test
    fun testCountCode() {
        val dayEightTestInput = Common.getFile("day8_testinput.txt")

        println(StringEscapeUtils.unescapeJava("\\u0027"))

        dayEightTestInput.forEachLine {
            var split = it.split(',')
            assertEquals(split[1].toInt(), ListCounter.countCode(split[0]))
            assertEquals(split[2].toInt(), ListCounter.countText(split[0]))
//            println("Expected: " + split[2].toInt())
//            println(ListCounter.countText(split[0]))
        }
    }
}