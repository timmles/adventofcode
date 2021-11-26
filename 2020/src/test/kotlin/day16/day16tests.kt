package year2020.day16

import common.Common
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

internal class Day16KtTest {

  @Test
  fun example1() {
    val input = """
      class: 1-3 or 5-7
      row: 6-11 or 33-44
      seat: 13-40 or 45-50

      your ticket:
      7,1,14

      nearby tickets:
      7,3,47
      40,4,50
      55,2,20
      38,6,12
    """.trimIndent().lines()

    assertEquals(71, TicketScanner(input).sumInvalidEntries())
  }

  @Test
  fun question1() {
    val input = Common.getFile("day16.txt").readLines()
    assertEquals(25788, TicketScanner(input).sumInvalidEntries())
  }

  @Test
  @Ignore
  fun example2() {
    val input = """
      class: 0-1 or 4-19
      row: 0-5 or 8-19
      seat: 0-13 or 16-19

      your ticket:
      11,12,13

      nearby tickets:
      3,9,18
      15,1,5
      5,14,9
    """.trimIndent().lines()

    assertEquals(1716, TicketScanner(input).multiplyTicketValues())
  }

  @Test
  fun question2() {
    val input = Common.getFile("day16.txt").readLines()
    assertEquals(3902565915559, TicketScanner(input).multiplyTicketValues())
  }
}
