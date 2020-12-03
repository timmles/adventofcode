package year2020.day1

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class DayOneKtTest {

  @Test
  fun example1() {
    val inputs = listOf(
      1721,
      979,
      366,
      299,
      675,
      1456)

    assertEquals(514579, findAndMultiplyPairs(inputs), "findPair example : fail")
  }

  @Test
  fun example2() {
    val inputs = listOf(
      1721,
      979,
      366,
      299,
      675,
      1456)

    assertEquals(241861950, findAndMultiplyTriples(inputs), "findPair example : fail")
  }

  @Test
  fun questionOne() {
    val inputs = Common.getFile("year2020/day1.txt").readLines().map { it.toInt() }

    assertEquals(224436, findAndMultiplyPairs(inputs), "findPair example : fail")
  }

  @Test
  fun questionTwo() {
    val inputs = Common.getFile("year2020/day1.txt").readLines().map { it.toInt() }

    assertEquals(303394260, findAndMultiplyTriples(inputs), "findPair example : fail")
  }
}
