package year2020.day2

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class DayTwoKtTest {

  @Test
  fun example1() {
    val input: List<String> = """
      1-3 a: abcde
      1-3 b: cdefg
      2-9 c: ccccccccc
    """.trimIndent().lines()


    assertEquals(2, SledPasswordDatabase(input).countValid())
  }

  @Test
  fun example2() {
    val input: List<String> = """
      1-3 a: abcde
      1-3 b: cdefg
      2-9 c: ccccccccc
    """.trimIndent().lines()


    assertEquals(1, TobogganPasswordDatabase(input).countValid())
  }

  @Test
  fun q1() {
    val input = Common.getFile("year2020/day2.txt").readLines()

    assertEquals(538, SledPasswordDatabase(input).countValid())
  }

  @Test
  fun q2() {
    val input = Common.getFile("year2020/day2.txt").readLines()

    assertEquals(489, TobogganPasswordDatabase(input).countValid())
  }
}
