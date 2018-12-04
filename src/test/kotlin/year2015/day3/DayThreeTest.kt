package year2015.day3

import org.junit.Assert.*
import org.junit.Test

class DayThreeTest {

    @Test
    fun testMoves1() {
        val neighbourhood = Neighbourhood()
        neighbourhood.deliverPresents(">")
        assertEquals(2, neighbourhood.countHouses())
    }

    @Test
    fun testMoves2() {
        val neighbourhood = Neighbourhood()
        neighbourhood.deliverPresents("^>v<")
        assertEquals(4, neighbourhood.countHouses())
    }

    @Test
    fun testMoves3() {
        val neighbourhood = Neighbourhood()
        neighbourhood.deliverPresents("^v^v^v^v^v")
        assertEquals(2, neighbourhood.countHouses())
    }
}