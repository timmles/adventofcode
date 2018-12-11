package year2018.day5

import common.Common
import org.junit.Test

class DayFiveTest {

    val dayFile = DayFive()

    @Test
    fun react_aA() {
        val result = dayFile.react("aA")
        kotlin.test.assertEquals("", result)
    }

    @Test
    fun react_abBA() {
        val result = dayFile.react("abBA")
        kotlin.test.assertEquals("", result)
    }

    @Test
    fun react_abAB() {
        val result = dayFile.react("abAB")
        kotlin.test.assertEquals("abAB", result)
    }

    @Test
    fun react_aabAAB() {
        val result = dayFile.react("aabAAB")
        kotlin.test.assertEquals("aabAAB", result)
    }

    @Test
    fun react_Larger() {
        val result = dayFile.react("dabAcCaCBAcCcaDA")
        kotlin.test.assertEquals("dabCBAcaDA", result)
    }

    @Test
    fun reactActual() {
        val claimsInput = Common.getFile("year2018/day5.txt").readLines()
        val result = dayFile.react(claimsInput[0])
        kotlin.test.assertEquals(11152, result.count())
    }

    @Test
    fun reactActualPt2() {
        val claimsInput = Common.getFile("year2018/day5.txt").readLines()
        val result = dayFile.react(claimsInput[0])

        val listOf = listOf(
                Pair("A", 0),
                Pair("B", 0),
                Pair("C", 0),
                Pair("D", 0),
                Pair("E", 0),
                Pair("F", 0),
                Pair("G", 0),
                Pair("H", 0),
                Pair("I", 0),
                Pair("J", 0),
                Pair("K", 0),
                Pair("L", 0),
                Pair("M", 0),
                Pair("N", 0),
                Pair("O", 0),
                Pair("P", 0),
                Pair("Q", 0),
                Pair("R", 0),
                Pair("S", 0),
                Pair("T", 0),
                Pair("U", 0),
                Pair("V", 0),
                Pair("W", 0),
                Pair("X", 0),
                Pair("Y", 0),
                Pair("Z", 0)
        )

        val map = listOf.map {
            val replace = claimsInput[0].replace(it.first, "").replace(it.first.toLowerCase(), "")
            Pair(it.first, dayFile.react(replace).count())
        }

        kotlin.test.assertEquals(6136, map.minBy { it.second }!!.second)
    }

}