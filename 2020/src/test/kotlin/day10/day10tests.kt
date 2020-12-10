package year2020.day10

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day10KtTest {

  @Test
  fun example1() {
    val input = """
      16
      10
      15
      5
      1
      11
      7
      19
      6
      12
      4
    """.trimIndent().lines().map { it.toInt() }

    assertEquals(7*5, Placeholder(input).usingAllAdaptors())
  }

  @Test
  fun example1_2() {
    val input = """
      28
      33
      18
      42
      31
      14
      46
      20
      48
      47
      24
      23
      49
      45
      19
      38
      39
      11
      1
      32
      25
      35
      8
      17
      7
      9
      4
      2
      34
      10
      3
    """.trimIndent().lines().map { it.toInt() }

    assertEquals(22*10, Placeholder(input).usingAllAdaptors())
  }

  @Test
  fun question1() {
    val input = Common.getFile("day10.txt").readLines().map { it.toInt() }
    assertEquals(1980, Placeholder(input).usingAllAdaptors())
  }

  @Test
  fun example2_1() {
    val input = """
      16
      10
      15
      5
      1
      11
      7
      19
      6
      12
      4
    """.trimIndent().lines().map { it.toInt() }

    assertEquals(8, Placeholder(input).possibleAdaptors())
  }

  @Test
  fun example2_2() {
    val input = """
      28
      33
      18
      42
      31
      14
      46
      20
      48
      47
      24
      23
      49
      45
      19
      38
      39
      11
      1
      32
      25
      35
      8
      17
      7
      9
      4
      2
      34
      10
      3
    """.trimIndent().lines().map { it.toInt() }

    assertEquals(19208, Placeholder(input).possibleAdaptors())
  }

  @Test
  fun question2() {
    val input = Common.getFile("day10.txt").readLines().map { it.toInt() }
    assertEquals(4628074479616, Placeholder(input).possibleAdaptors())
  }
}

