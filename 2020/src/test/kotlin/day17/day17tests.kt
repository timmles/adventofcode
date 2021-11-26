package year2020.day17

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day17KtTest {

  @Test
  fun example1_naive() {
    val input = """
      .#.
      ..#
      ###
    """.trimIndent().lines()

    assertEquals(112, PowerCubeNaive(input).doWork())
  }

  @Test
  fun question1_naive() {
    val input = Common.getFile("day17.txt").readLines()
    assertEquals(301, PowerCubeNaive(input).doWork())
  }
}
