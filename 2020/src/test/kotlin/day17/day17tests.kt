package year2020.day17

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day17KtTest {

  @Test
  fun example1() {
    val input = """
      .#.
      ..#
      ###
    """.trimIndent().lines()

    assertEquals(112, Placeholder(input).doWork())
  }

  @Test
  fun question1() {
    val input = Common.getFile("day17.txt").readLines()
    assertEquals(301, Placeholder(input).doWork())
  }

  @Test
  fun example2() {
    val input = """
      .#.
      ..#
      ###
    """.trimIndent().lines()

    assertEquals(848, Placeholder4D(input).doWork4D())
  }

  @Test
  fun question2() {
    val input = Common.getFile("day17.txt").readLines()
    assertEquals(1, Placeholder4D(input).doWork4D())
  }
}

