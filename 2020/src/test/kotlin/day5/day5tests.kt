package year2020.day5

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day5KtTest {

  @Test
  fun example1() {
    val input = """
      FBFBBFFRLR
      BFFFBBFRRR
      FFFBBBFRRR
      BBFFBBFRLL
    """.trimIndent().lines()

    val aeroplane = Aeroplane(input)

    assertEquals(357, aeroplane.seatId("FBFBBFFRLR"))
    assertEquals(567, aeroplane.seatId("BFFFBBFRRR"))
    assertEquals(119, aeroplane.seatId("FFFBBBFRRR"))
    assertEquals(820, aeroplane.seatId("BBFFBBFRLL"))
    assertEquals(820, aeroplane.highestSeatId())
  }

  @Test
  fun question1() {
    val input = Common.getFile("day5.txt").readLines()
    assertEquals(880, Aeroplane(input).highestSeatId())
  }

  @Test
  fun question2() {
    val input = Common.getFile("day5.txt").readLines()
    assertEquals(731, Aeroplane(input).searchEmptySeat())
  }
}

