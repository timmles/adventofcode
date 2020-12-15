package year2020.day14

import common.Common
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

internal class Day14KtTest {

  @Test
  fun exampleBitShift() {
    assertEquals(73, PartOne.mask(11, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"))
    assertEquals(101, PartOne.mask(101, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"))
    assertEquals(64, PartOne.mask(0, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"))
  }

  @Test
  fun example1() {
    val input = """
      mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
      mem[8] = 11
      mem[7] = 101
      mem[8] = 0
    """.trimIndent().lines()

    assertEquals(165, PartOne.doWork(input))
  }

  @Test
  fun question1() {
    val input = Common.getFile("day14.txt").readLines()
    assertEquals(10050490168421, PartOne.doWork(input))
  }

  @Ignore
  @Test
  fun example2() {
    val input = """

    """.trimIndent().lines()

    assertEquals(1, PartOne.doWork(input))
  }

  @Ignore
  @Test
  fun question2() {
    val input = Common.getFile("day14.txt").readLines()
    assertEquals(1, PartOne.doWork(input))
  }
}

