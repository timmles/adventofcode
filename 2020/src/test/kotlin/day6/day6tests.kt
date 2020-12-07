package year2020.day6

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day6KtTest {

  @Test
  fun example1() {
    val input = """
      abc

      a
      b
      c

      ab
      ac

      a
      a
      a
      a

      b
    """.trimIndent().lines()

    assertEquals(11, Placeholder(input).doWork())
  }

  @Test
  fun question1() {
    val input = Common.getFile("day6.txt").readLines()
    assertEquals(6680, Placeholder(input).doWork())
  }

  @Test
  fun example2() {
    val input = """
      abc

      a
      b
      c

      ab
      ac

      a
      a
      a
      a

      b
    """.trimIndent().lines()

    assertEquals(6, Placeholder(input).doWorkAllPeople())
  }

  @Test
  fun question2() {
    val input = Common.getFile("day6.txt").readLines()
    assertEquals(3117, Placeholder(input).doWorkAllPeople())
  }
}

