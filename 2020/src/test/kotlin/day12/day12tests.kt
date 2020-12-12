package year2020.day12

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day12KtTest {

  @Test
  fun example1() {
    val input = """
      F10
      N3
      F7
      R90
      F11
    """.trimIndent().lines()

    assertEquals(25, Ship(input).followInstructions())
  }

  @Test
  fun question1() {
    val input = Common.getFile("day12.txt").readLines()
    assertEquals(441, Ship(input).followInstructions())
  }

  @Test
  fun example2() {
    val input = """
      F10
      N3
      F7
      R90
      F11
    """.trimIndent().lines()

    assertEquals(286, Ship2(input).followInstructions())
  }

  @Test
  fun question2() {
    val input = Common.getFile("day12.txt").readLines()
    assertEquals(40014, Ship2(input).followInstructions())
  }
}

