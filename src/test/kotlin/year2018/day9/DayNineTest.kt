package year2018.day6

import common.Common
import org.junit.Test
import year2018.day9.DayNine

class DayNineTest {
    @Test
    fun findXXX1() {
        val map = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"
                .split(" ")
                .map { it.toInt() }


        kotlin.test.assertEquals(32, DayNine().play(9, 25))
        kotlin.test.assertEquals(8317, DayNine().play(10, 1618))
        kotlin.test.assertEquals(146373, DayNine().play(13, 7999))
        kotlin.test.assertEquals(2764, DayNine().play(17, 1104))
        kotlin.test.assertEquals(54718, DayNine().play(21, 6111))
        kotlin.test.assertEquals(37305, DayNine().play(30, 5807))
        kotlin.test.assertEquals(373597, DayNine().play(486, 70833))
//        kotlin.test.assertEquals(2954067253, DayNine().play(486, 7083300))
    }

//    @Test
//    fun findXXX1Actual() {
//        val map = Common.getFile("year2018/day9.txt").readLines()[0]
//                .split(" ")
//                .map { it.toInt() }
//        val metadata = DayNine(map).metaCheck()
//        kotlin.test.assertEquals(35911, metadata)
//    }
//
//    @Test
//    fun findXXX2() {
//        val map = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"
//                .split(" ")
//                .map { it.toInt() }
//
//
//        val metadata = DayNine(map).nodeValue()
//        kotlin.test.assertEquals(66, metadata)
//    }
//
//    @Test
//    fun findXXX2Actual() {
//        val map = Common.getFile("year2018/day9.txt").readLines()[0]
//                .split(" ")
//                .map { it.toInt() }
//        val metadata = DayNine(map).nodeValue()
//        kotlin.test.assertEquals(138, metadata)
//    }

    @Test
    fun testShift() {
        val dayNine = DayNine()
        kotlin.test.assertEquals(1, dayNine.shift(0, 2, 1))
        kotlin.test.assertEquals(4, dayNine.shift(3, 1, 10))
        kotlin.test.assertEquals(3, dayNine.shift(3, 10, 10))
        kotlin.test.assertEquals(3, dayNine.shift(3, 100, 10))
        kotlin.test.assertEquals(8, dayNine.shift(3, 15, 10))
        kotlin.test.assertEquals(8, dayNine.shift(3, 15, 10))
        kotlin.test.assertEquals(6, dayNine.shift(3, -7, 10))
    }
}