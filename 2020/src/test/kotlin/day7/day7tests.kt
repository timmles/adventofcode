package year2020.day7

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day7KtTest {

  @Test
  fun example1() {
    val input = """
      light red bags contain 1 bright white bag, 2 muted yellow bags.
      dark orange bags contain 3 bright white bags, 4 muted yellow bags.
      bright white bags contain 1 shiny gold bag.
      muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
      shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
      dark olive bags contain 3 faded blue bags, 4 dotted black bags.
      vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
      faded blue bags contain no other bags.
      dotted black bags contain no other bags.
    """.trimIndent().lines()

    assertEquals(4, LuggageProcessor(input).possibleContainers("shiny gold"))
  }

  @Test
  fun question1() {
    val input = Common.getFile("day7.txt").readLines()
    assertEquals(233, LuggageProcessor(input).possibleContainers("shiny gold"))
  }

  @Test
  fun example2() {
    val input1 = """
      light red bags contain 1 bright white bag, 2 muted yellow bags.
      dark orange bags contain 3 bright white bags, 4 muted yellow bags.
      bright white bags contain 1 shiny gold bag.
      muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
      shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
      dark olive bags contain 3 faded blue bags, 4 dotted black bags.
      vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
      faded blue bags contain no other bags.
      dotted black bags contain no other bags.
    """.trimIndent().lines()

    val input2 = """
      shiny gold bags contain 2 dark red bags.
      dark red bags contain 2 dark orange bags.
      dark orange bags contain 2 dark yellow bags.
      dark yellow bags contain 2 dark green bags.
      dark green bags contain 2 dark blue bags.
      dark blue bags contain 2 dark violet bags.
      dark violet bags contain no other bags.
    """.trimIndent().lines()



    assertEquals(32, LuggageProcessor(input1).requiredBagsFromTarget("shiny gold"))
    assertEquals(126, LuggageProcessor(input2).requiredBagsFromTarget("shiny gold"))
  }

  @Test
  fun question2() {
    val input = Common.getFile("day7.txt").readLines()
    assertEquals(421550, LuggageProcessor(input).requiredBagsFromTarget("shiny gold"))
  }
}

