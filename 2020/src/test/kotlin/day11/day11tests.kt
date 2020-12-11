package year2020.day11

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day11KtTest {

  @Test
  fun example1() {
    val input = """
      L.LL.LL.LL
      LLLLLLL.LL
      L.L.L..L..
      LLLL.LL.LL
      L.LL.LL.LL
      L.LLLLL.LL
      ..L.L.....
      LLLLLLLLLL
      L.LLLLLL.L
      L.LLLLL.LL
    """.trimIndent().lines()

    assertEquals(37, GameOfLife1(input).doWork())
  }

  @Test
  fun question1() {
    val input = Common.getFile("day11.txt").readLines()
    assertEquals(2277, GameOfLife1(input).doWork())
  }

  @Test
  fun example2() {
    val input = """
      L.LL.LL.LL
      LLLLLLL.LL
      L.L.L..L..
      LLLL.LL.LL
      L.LL.LL.LL
      L.LLLLL.LL
      ..L.L.....
      LLLLLLLLLL
      L.LLLLLL.L
      L.LLLLL.LL
    """.trimIndent().lines()

    assertEquals(26, GameOfLife2(input).doWork())
  }

  @Test
  fun question2() {
    val input = Common.getFile("day11.txt").readLines()
    assertEquals(2066, GameOfLife2(input).doWork())
  }
}

