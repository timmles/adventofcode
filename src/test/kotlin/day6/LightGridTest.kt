package day6

import org.junit.Assert.*
import org.junit.Test

class LightGridTest {
    @Test
    fun testParse() {
        var grid = LightGrid()

        val instructionActual = grid.parseInstruction("turn on 0,0 through 999,999")
        val instructionExpected = Instruction(LightAction.TURN_ON, Pair(0,0), Pair(999, 999))

        assertEquals(instructionExpected, instructionActual)
    }

    @Test
    fun testConfigAll() {
        var grid = LightGrid()

        grid.configureLights(Instruction(LightAction.TURN_ON, Pair(0,0), Pair(999, 999)))

        assertEquals(1000*1000, grid.countLights())
    }

    @Test
    fun testConfigRow() {
        var grid = LightGrid()

        grid.configureLights(Instruction(LightAction.TURN_ON, Pair(0,0), Pair(999, 0)))

        assertEquals(1000, grid.countLights())
    }

    @Test
    fun testConfigFour() {
        var grid = LightGrid()

        grid.configureLights(Instruction(LightAction.TOGGLE, Pair(499,499), Pair(500, 500)))

        assertEquals(4, grid.countLights())
    }

}