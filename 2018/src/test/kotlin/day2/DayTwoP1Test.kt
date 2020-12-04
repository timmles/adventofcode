package year2018.day2

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

class DayTwoP1Test {

    @Test
    fun checksum() {
        val listOf = listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")

        val destruct = DayTwoP1().checksum(listOf)
        print(destruct)
    }

    @Test
    fun checksumActual() {
        val listOf = Common.getFile("day2.txt").readLines()

        val destruct = DayTwoP1().checksum(listOf)
        print(destruct)
    }
}

class DayTwoP2Test {

    @Test
    fun find0() {
        val listOf = listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")

        val find = DayTwoP2().find(listOf)
        assertEquals("fgij", find, "findActual : find : fail")
    }

    @Test
    fun findActual() {
        val listOf = Common.getFile("day2.txt").readLines()

        val find = DayTwoP2().find(listOf)
        assertEquals("lujnogabetpmsydyfcovzixaw", find, "findActual : find : fail")
    }
}

