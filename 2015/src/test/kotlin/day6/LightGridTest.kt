package year2015.day6

import common.Common
import org.junit.Assert.*
import org.junit.Test

class LightGridTest {
  @Test
  fun testParse() {
    val grid = LightGrid()

    val instructionActual = grid.parseInstruction("turn on 0,0 through 999,999")
    val instructionExpected = Instruction(LightAction.TURN_ON, Pair(0, 0), Pair(999, 999))

    assertEquals(instructionExpected, instructionActual)
  }

  @Test
  fun testConfigAll() {
    val grid = LightGrid()

    grid.configureLightsQ1(Instruction(LightAction.TURN_ON, Pair(0, 0), Pair(999, 999)))

    assertEquals(1000 * 1000, grid.countLights())
  }

  @Test
  fun testConfigRow() {
    val grid = LightGrid()

    grid.configureLightsQ1(Instruction(LightAction.TURN_ON, Pair(0, 0), Pair(999, 0)))

    assertEquals(1000, grid.countLights())
  }

  @Test
  fun testConfigFour() {
    val grid = LightGrid()

    grid.configureLightsQ1(Instruction(LightAction.TOGGLE, Pair(499, 499), Pair(500, 500)))

    assertEquals(4, grid.countLights())
  }

  @Test
  fun question1() {
    val grid = LightGrid()
    Common.getFile("day6.txt").readLines().forEach {
      grid.configureLightsQ1(grid.parseInstruction(it))
    }

    assertEquals(543903, grid.countLights())
  }

  @Test
  fun question2() {
    val grid = LightGrid()
    Common.getFile("day6.txt").forEachLine {
      grid.configureLightsQ2(grid.parseInstruction(it))
    }

    assertEquals(14687245, grid.sumLights())
  }
}
