package year2020.day9

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day9KtTest {

  @Test
  fun example1() {
    val input = """
      35
      20
      15
      25
      47
      40
      62
      55
      65
      95
      102
      117
      150
      182
      127
      219
      299
      277
      309
      576
    """.trimIndent().lines().map { it.toLong() }

    assertEquals(127, XmasCracker().findFirstInvalid(5, input))
  }

  @Test
  fun question1() {
    val input = Common.getFile("day9.txt").readLines().map { it.toLong() }
    assertEquals(1398413738, XmasCracker().findFirstInvalid(25, input))
  }

  @Test
  fun example2() {
    val input = """
      35
      20
      15
      25
      47
      40
      62
      55
      65
      95
      102
      117
      150
      182
      127
      219
      299
      277
      309
      576
    """.trimIndent().lines().map { it.toLong() }

    val findFirstInvalid = XmasCracker().findFirstInvalid(5, input)
    assertEquals(62, XmasCracker().findWeakness(findFirstInvalid, input))
  }

  @Test
  fun question2() {
    val input = Common.getFile("day9.txt").readLines().map { it.toLong() }
    val findFirstInvalid = XmasCracker().findFirstInvalid(25, input)
    assertEquals(169521051, XmasCracker().findWeakness(findFirstInvalid, input))
  }
}
