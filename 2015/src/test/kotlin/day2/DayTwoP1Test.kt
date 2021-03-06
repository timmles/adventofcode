package year2015.day2

import org.junit.Assert.*
import org.junit.Test

class DayTwoP1Test {

    @Test
    fun testFactory() {
        val presentFactory = PresentFactory();

        val presentActual: Present = presentFactory.createPresent("2x3x4")
        val presentExpected: Present = Present(2, 3, 4)

        assertEquals(presentActual, presentExpected)
    }

    @Test
    fun testSurface() {
        val present = Present(2, 3, 4)
        val surface = present.getSurface();
        assertEquals(52, surface)
    }

    @Test
    fun testSlack() {
        val present = Present(2, 3, 4)
        val slack = present.getSlack()
        assertEquals(6, slack)
    }

    @Test
    fun testRibbonBox() {
        val present = Present(2, 3, 4)
        val ribbon = present.getRibbonBox()
        assertEquals(10, ribbon)
    }

    @Test
    fun testRibbonBow() {
        val present = Present(2, 3, 4)
        val ribbon = present.getRibbonBow()
        assertEquals(24, ribbon)
    }
}


