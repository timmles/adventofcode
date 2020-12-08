package year2020.day8

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day8KtTest {

  @Test
  fun example1() {
    val input = """
      nop +0
      acc +1
      jmp +4
      acc +3
      jmp -3
      acc -99
      acc +1
      jmp -4
      acc +6
    """.trimIndent().lines()

    assertEquals(5, TerminalByInstruction(input).process().accumulator)
  }

  @Test
  fun question1() {
    val input = Common.getFile("day8.txt").readLines()
    assertEquals(1451, TerminalByInstruction(input).process().accumulator)
  }

  @Test
  fun example2() {
    val input = """
      nop +0
      acc +1
      jmp +4
      acc +3
      jmp -3
      acc -99
      acc +1
      jmp -4
      acc +6
    """.trimIndent().lines()

    assertEquals(8, searchForFix(input))
  }

  @Test
  fun question2() {
    val input = Common.getFile("day8.txt").readLines()
    assertEquals(1160, searchForFix(input))
  }
}

