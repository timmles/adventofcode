package year2018.day10

import common.Common
import org.junit.Test

class DayTenTest {

    @Test
    fun findMessage() {
        val points = listOf(
                "position=< 9,  1> velocity=< 0,  2>",
                "position=< 7,  0> velocity=<-1,  0>",
                "position=< 3, -2> velocity=<-1,  1>",
                "position=< 6, 10> velocity=<-2, -1>",
                "position=< 2, -4> velocity=< 2,  2>",
                "position=<-6, 10> velocity=< 2, -2>",
                "position=< 1,  8> velocity=< 1, -1>",
                "position=< 1,  7> velocity=< 1,  0>",
                "position=<-3, 11> velocity=< 1, -2>",
                "position=< 7,  6> velocity=<-1, -1>",
                "position=<-2,  3> velocity=< 1,  0>",
                "position=<-4,  3> velocity=< 2,  0>",
                "position=<10, -3> velocity=<-1,  1>",
                "position=< 5, 11> velocity=< 1, -2>",
                "position=< 4,  7> velocity=< 0, -1>",
                "position=< 8, -2> velocity=< 0,  1>",
                "position=<15,  0> velocity=<-2,  0>",
                "position=< 1,  6> velocity=< 1,  0>",
                "position=< 8,  9> velocity=< 0, -1>",
                "position=< 3,  3> velocity=<-1,  1>",
                "position=< 0,  5> velocity=< 0, -1>",
                "position=<-2,  2> velocity=< 2,  0>",
                "position=< 5, -2> velocity=< 1,  2>",
                "position=< 1,  4> velocity=< 2,  1>",
                "position=<-2,  7> velocity=< 2, -2>",
                "position=< 3,  6> velocity=<-1, -1>",
                "position=< 5,  0> velocity=< 1,  0>",
                "position=<-6,  0> velocity=< 2,  0>",
                "position=< 5,  9> velocity=< 1, -2>",
                "position=<14,  7> velocity=<-2,  0>",
                "position=<-3,  6> velocity=< 2, -1>")

        val message = DayTen(points, 8)
        println("Durations to find :: ${message.seconds}")
        kotlin.test.assertEquals(88, message.toString().count())
        kotlin.test.assertEquals(3, message.seconds)
    }

    @Test
    fun findMetaDataActual() {
        val points = Common.getFile("day10.txt").readLines()

        val message = DayTen(points, 10)
        println("Durations to find :: ${message.seconds}")
        kotlin.test.assertEquals(630, message.toString().count())
        kotlin.test.assertEquals(10656, message.seconds)
    }
//
//    @Test
//    fun findNodeValue() {
//        val map = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"
//                .split(" ")
//                .map { it.toInt() }
//
//
//        val metadata = DayTen(map).nodeValue()
//        kotlin.test.assertEquals(66, metadata)
//    }
//
//    @Test
//    fun findNodeValueActual() {
//        val map = Common.getFile("day10.txt").readLines()[0]
//                .split(" ")
//                .map { it.toInt() }
//        val metadata = DayTen(map).nodeValue()
//        kotlin.test.assertEquals(138, metadata)
//    }
}
