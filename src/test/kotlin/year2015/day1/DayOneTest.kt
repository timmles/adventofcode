package year2015.day1

import org.junit.Test
import kotlin.test.assertEquals

public class DayOneTest {
    var dayOne = DayOne()

    @Test
    fun testFloor0() {
        var resultantFloor1: Int = dayOne.walkFloors("(())")
        var resultantFloor2: Int = dayOne.walkFloors("()()")

        assertEquals(0, resultantFloor1, "testFloor0 : resultantFloor1 : fail")
        assertEquals(0, resultantFloor2, "testFloor0 : resultantFloor2 : fail")
    }

    @Test
    fun testFloor3() {
        var resultantFloor1: Int = dayOne.walkFloors("(((")
        var resultantFloor2: Int = dayOne.walkFloors("(((")
        var resultantFloor3: Int = dayOne.walkFloors("(()(()(")

        assertEquals(3, resultantFloor1, "testFloor1 : resultantFloor1 : fail")
        assertEquals(3, resultantFloor2, "testFloor1 : resultantFloor2 : fail")
        assertEquals(3, resultantFloor3, "testFloor1 : resultantFloor3 : fail")
    }

    @Test
    fun testFloorNeg1() {
        var resultantFloor1: Int = dayOne.walkFloors("())")
        var resultantFloor2: Int = dayOne.walkFloors("))(")

        assertEquals(-1, resultantFloor1, "testFloorNeg1 : resultantFloor1 : fail")
        assertEquals(-1, resultantFloor2, "testFloorNeg1 : resultantFloor2 : fail")
    }
}