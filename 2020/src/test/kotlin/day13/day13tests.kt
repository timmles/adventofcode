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

    assertEquals(3417, Placeholder().part2_bruteforce(listOf("", "17,x,13,19"), 25))
    assertEquals(754018, Placeholder().part2_bruteforce(listOf("", "67,7,59,61"),744018))
//    assertEquals(779210, Placeholder().part2_bruteforce(listOf("", "67,x,7,59,61")))
//    assertEquals(1068781, Placeholder().part2_bruteforce(input))
//    assertEquals(1261476, Placeholder().part2_bruteforce(listOf("", "67,7,x,59,61")))
//    assertEquals(1202161486, Placeholder().part2_bruteforce(listOf("", "1789,37,47,1889")))
  }

  @Test
  fun question2() {
    val input = Common.getFile("day13.txt").readLines()
    assertEquals(1068781, Placeholder().part2_bruteforce(input, 100_000_000_000_000))
  }
}

