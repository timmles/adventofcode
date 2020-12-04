package year2018.day11

import common.Common
import org.junit.Test

class DayElevenTest {

    @Test
    fun calculatePower() {
        kotlin.test.assertEquals( 4, DayEleven(8).calculatePower(3,5))
        kotlin.test.assertEquals(-5, DayEleven(57).calculatePower(122,79))
        kotlin.test.assertEquals( 0, DayEleven(39).calculatePower(217,196))
        kotlin.test.assertEquals( 4, DayEleven(71).calculatePower(101,153))
    }

    @Test
    fun powerGrid() {
        kotlin.test.assertEquals( Triple(33,45,29), DayEleven(18).searchLargest(3))
        kotlin.test.assertEquals( Triple(21,61, 30), DayEleven(42).searchLargest(3))
        kotlin.test.assertEquals( Triple(21, 93, 29), DayEleven(1955).searchLargest(3))
    }

    @Test
    fun powerGridVariable() {
        kotlin.test.assertEquals( Point(90,269,113,16), DayEleven(18).searchLargestVariable())
        kotlin.test.assertEquals( Point(232,251,119,12), DayEleven(42).searchLargestVariable())
        kotlin.test.assertEquals( Point(231,108,171,14), DayEleven(1955).searchLargestVariable())
    }
}