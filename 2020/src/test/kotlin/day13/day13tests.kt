package year2020.day13

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day13KtTest {

  @Test
  fun example1() {
    val input = """
      939
      7,13,x,x,59,x,31,19
    """.trimIndent().lines()

    assertEquals(295, Placeholder().part1(input))
  }

  @Test
  fun question1() {
    val input = Common.getFile("day13.txt").readLines()
    assertEquals(3269, Placeholder().part1(input))
  }

  @Test
  fun example2() {
    val input = """
      939
      7,13,x,x,59,x,31,19
    """.trimIndent().lines()

    assertEquals(1068781, Placeholder().part2(input))
  }

//  @Test
//  fun question2() {
//    val input = Common.getFile("day13.txt").readLines()
//    assertEquals(1, Placeholder().part2(input))
//  }
}

