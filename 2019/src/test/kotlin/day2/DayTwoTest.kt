package year2019.day2

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

class DayTwoTest {

  @Test
  fun example1() {
    assertEquals("3500,9,10,70,2,3,11,0,99,30,40,50", calculate("1,9,10,3,2,3,11,0,99,30,40,50"))
    assertEquals("2,0,0,0,99", calculate("1,0,0,0,99"))
    assertEquals("2,3,0,6,99", calculate("2,3,0,3,99"))
    assertEquals("2,4,4,5,99,9801", calculate("2,4,4,5,99,0"))
    assertEquals("30,1,1,4,2,5,6,0,99", calculate("1,1,1,4,99,5,6,0,99"))
  }

  @Test
  fun question1() {
    val expected = "3306701,12,2,2,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,60,1,9,19,63,2,23,13,315,1,27,9,318,2,31,6,636,1,5,35,637,1,10,39,641,2,43,6,1282,1,10,47,1286,2,6,51,2572,1,5,55,2573,1,59,9,2576,1,13,63,2581,2,6,67,5162,1,5,71,5163,2,6,75,10326,2,79,6,20652,1,13,83,20657,1,9,87,20660,1,9,91,20663,1,5,95,20664,1,5,99,20665,2,13,103,103325,1,6,107,103327,1,9,111,103330,2,6,115,206660,1,13,119,206665,1,123,6,206667,1,127,5,206668,2,10,131,826672,2,135,10,3306688,1,13,139,3306693,1,10,143,3306697,1,2,147,3306699,1,6,151,0,99,2,14,0,0"
    assertEquals(expected, calculate(Common.getFile("day2.txt").readLines().first()))
  }

  @Test
  fun testQ2() {
    var answerNoun = 0
    var answerVerb = 0
    for (noun in 0..99) {
      for (verb in 0..99) {
        val calculate = calculate("1,$noun,$verb,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,9,19,23,2,23,13,27,1,27,9,31,2,31,6,35,1,5,35,39,1,10,39,43,2,43,6,47,1,10,47,51,2,6,51,55,1,5,55,59,1,59,9,63,1,13,63,67,2,6,67,71,1,5,71,75,2,6,75,79,2,79,6,83,1,13,83,87,1,9,87,91,1,9,91,95,1,5,95,99,1,5,99,103,2,13,103,107,1,6,107,111,1,9,111,115,2,6,115,119,1,13,119,123,1,123,6,127,1,127,5,131,2,10,131,135,2,135,10,139,1,13,139,143,1,10,143,147,1,2,147,151,1,6,151,0,99,2,14,0,0")
        if (calculate.substringBefore(',') == "19690720") {
          answerNoun = noun
          answerVerb = verb
        }
      }
    }

    assertEquals("7621", "$answerNoun$answerVerb")
  }
}

