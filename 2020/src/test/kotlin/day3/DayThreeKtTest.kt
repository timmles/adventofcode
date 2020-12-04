package year2020.day3

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class DayThreeKtTest {

  @Test
  fun example1() {
    val map = """
      ..##.......
      #...#...#..
      .#....#..#.
      ..#.#...#.#
      .#...##..#.
      ..#.##.....
      .#.#.#....#
      .#........#
      #.##...#...
      #...##....#
      .#..#...#.#
    """.trimIndent().lines()

    assertEquals(7, AdventMap(map).traverse(Pair(3,1)))
  }

  @Test
  fun question1() {
    val input = Common.getFile("day3.txt").readLines()
    assertEquals(151, AdventMap(input).traverse(Pair(3, 1)))
  }

  @Test
  fun example2() {
    val map = """
      ..##.......
      #...#...#..
      .#....#..#.
      ..#.#...#.#
      .#...##..#.
      ..#.##.....
      .#.#.#....#
      .#........#
      #.##...#...
      #...##....#
      .#..#...#.#
    """.trimIndent().lines()

    assertEquals(2, AdventMap(map).traverse(Pair(1, 1)))
    assertEquals(7, AdventMap(map).traverse(Pair(3, 1)))
    assertEquals(3, AdventMap(map).traverse(Pair(5, 1)))
    assertEquals(4, AdventMap(map).traverse(Pair(7, 1)))
    assertEquals(2, AdventMap(map).traverse(Pair(1, 2)))

    assertEquals(336, AdventMap(map).traverseSearch(listOf(
      Pair(1, 1),
      Pair(3, 1),
      Pair(5, 1),
      Pair(7, 1),
      Pair(1, 2)
    )))
  }

  @Test
  fun question2() {
    val input = Common.getFile("day3.txt").readLines()
    assertEquals(7540141059, AdventMap(input).traverseSearch(listOf(
      Pair(1, 1),
      Pair(3, 1),
      Pair(5, 1),
      Pair(7, 1),
      Pair(1, 2)
    )))
  }
}
