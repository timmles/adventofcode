package year2018.day1

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

class DayOneTest {

    var dayOne = DayOne()

//    +1, +1, +1 results in  3
//    +1, +1, -2 results in  0
//    -1, -2, -3 results in -6

    @Test
    fun testDrift0() {
        val drift: List<Int> = listOf(1, 1, 1)
        val resultantFrequency: Int = dayOne.drift(0, drift)

        assertEquals(3, resultantFrequency, "testDrift0 : resultantFrequency : fail")
    }
    
    @Test
    fun testDrift1() {
        val drift: List<Int> = listOf(1, 1, -2)
        val resultantFrequency: Int = dayOne.drift(0, drift)

        assertEquals(0, resultantFrequency, "testDrift1 : resultantFrequency : fail")
    }
    
    @Test
    fun testDrift2() {
        val drift: List<Int> = listOf(-1, -2, -3)
        val resultantFrequency: Int = dayOne.drift(0, drift)

        assertEquals(-6, resultantFrequency, "testDrift2 : resultantFrequency : fail")
    }

    @Test
    fun testActual() {
        val drift: MutableList<Int> = mutableListOf()
        val file = Common.getFile("year2018/dayOne.txt").forEachLine { drift.add(it.toInt()) }

        val resultantFrequency: Int = dayOne.drift(0, drift)

        assertEquals(553, resultantFrequency, "testDrift2 : resultantFrequency : fail")
    }

    @Test
    fun testFind0() {
        val drift: List<Int> = listOf(1, -1)
        val resultantFrequency: Int = dayOne.findFirstRepeatedFrequency(0, drift)

        assertEquals(0, resultantFrequency, "testFind0 : resultantFrequency : fail")
    }

    @Test
    fun testFind1() {
        val drift: List<Int> = listOf(+3, +3, +4, -2, -4)
        val resultantFrequency: Int = dayOne.findFirstRepeatedFrequency(0, drift)

        assertEquals(10, resultantFrequency, "testFind0 : resultantFrequency : fail")
    }

    @Test
    fun testFind2() {
        val drift: List<Int> = listOf(-6, +3, +8, +5, -6)
        val resultantFrequency: Int = dayOne.findFirstRepeatedFrequency(0, drift)

        assertEquals(5, resultantFrequency, "testFind0 : resultantFrequency : fail")
    }

    @Test
    fun testFind3() {
        val drift: List<Int> = listOf(+7, +7, -2, -7, -4)
        val resultantFrequency: Int = dayOne.findFirstRepeatedFrequency(0, drift)

        assertEquals(14, resultantFrequency, "testFind0 : resultantFrequency : fail")
    }

    @Test
    fun testFindActual() {
        val drift: MutableList<Int> = mutableListOf()
        val file = Common.getFile("year2018/dayOne.txt").forEachLine { drift.add(it.toInt()) }

        val resultantFrequency: Int = dayOne.findFirstRepeatedFrequency(0, drift)

        assertEquals(78724, resultantFrequency, "testDrift2 : resultantFrequency : fail")
    }
}
