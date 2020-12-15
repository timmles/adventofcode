package common

import org.junit.Test
import kotlin.test.assertEquals

internal class ChineseRemainderTheoremTest {

  @Test
  fun findMinX() {
    assertEquals(11, ChineseRemainderTheorem.calculate(longArrayOf(3, 4, 5), longArrayOf(2, 3, 1)))
    assertEquals(3417, ChineseRemainderTheorem.calculate(longArrayOf(17, 13, 19), longArrayOf(0, 11, 16)))
    assertEquals(754018, ChineseRemainderTheorem.calculate(longArrayOf(67, 7, 59, 61), longArrayOf(0, 6, 57, 58)))
    assertEquals(779210, ChineseRemainderTheorem.calculate(longArrayOf(67, 7, 59, 61), longArrayOf(0, 5, 56, 57)))
    assertEquals(1068781, ChineseRemainderTheorem.calculate(longArrayOf(7, 13, 59, 31, 19), longArrayOf(0, 12, 55, 25, 12)))
    assertEquals(1261476, ChineseRemainderTheorem.calculate(longArrayOf(67, 7, 59, 61), longArrayOf(0, 6, 56, 57)))
    assertEquals(1202161486, ChineseRemainderTheorem.calculate(longArrayOf(1789, 37, 47, 1889), longArrayOf(0, 36, 45, 1886)))
  }
}
