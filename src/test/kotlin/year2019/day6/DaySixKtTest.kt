package year2019.day6

import common.Common
import org.junit.Test
import kotlin.test.assertEquals


internal class DaySixKtTest {

  @Test
  fun test1() {
    val s = """
      COM)B
      B)C
      C)D
      D)E
      E)F
      B)G
      G)H
      D)I
      E)J
      J)K
      K)L
    """
    assertEquals(42, Universe(s.trimIndent().split("\n")).checksum())
  }

  @Test
  fun q1() {
    assertEquals(314702, Universe(Common.getFile("year2019/day6.txt").readLines()).checksum())
  }

  @Test
  fun test2() {
    val s = """
      COM)B
      B)C
      C)D
      D)E
      E)F
      B)G
      G)H
      D)I
      E)J
      J)K
      K)L
      K)YOU
      I)SAN
    """.trimIndent()

    assertEquals(4, Universe(s.split("\n")).orbitalTransfers())
  }

  @Test
  fun q2() {
    assertEquals(439, Universe(Common.getFile("year2019/day6.txt").readLines()).orbitalTransfers())
  }

}
