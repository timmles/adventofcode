package year2018.day6

import common.Common
import org.junit.Test
import year2018.day8.DayEight

class DayEightTest {
    @Test
    fun findMetaData() {
        val map = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"
                .split(" ")
                .map { it.toInt() }


        val metadata = DayEight(map).metaCheck()
        kotlin.test.assertEquals(138, metadata)
    }

    @Test
    fun findMetaDataActual() {
        val map = Common.getFile("year2018/day8.txt").readLines()[0]
                .split(" ")
                .map { it.toInt() }
        val metadata = DayEight(map).metaCheck()
        kotlin.test.assertEquals(35911, metadata)
    }

    @Test
    fun findNodeValue() {
        val map = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"
                .split(" ")
                .map { it.toInt() }


        val metadata = DayEight(map).nodeValue()
        kotlin.test.assertEquals(66, metadata)
    }

    @Test
    fun findNodeValueActual() {
        val map = Common.getFile("year2018/day8.txt").readLines()[0]
                .split(" ")
                .map { it.toInt() }
        val metadata = DayEight(map).nodeValue()
        kotlin.test.assertEquals(138, metadata)
    }
}