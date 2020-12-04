package year2015.day8

import common.Common
import org.apache.commons.lang3.StringEscapeUtils
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class ListCounterTest {
    @Test
    fun testCountCode() {
        val dayEightTestInput =
          """
            "",2,0
            "aaa\"aaa",10,7
            "abc",5,3
            "\x27",6,1
          """.trimIndent().lines()

        println(StringEscapeUtils.unescapeJava("\\u0027"))

        dayEightTestInput.forEach {
            val split = it.split(',')
            assertEquals(split[1].toInt(), ListCounter.countCode(split[0]))
            assertEquals(split[2].toInt(), ListCounter.countText(split[0]))
        }
    }

  @Test
  @Ignore
  fun question1() {
    val dayEightInput = Common.getFile("day8.txt")

    var countCode = 0;
    var countText = 0
    dayEightInput.forEachLine {
      println("input: " + it)

      val countCode1 = ListCounter.countCode(it)
      val countText1 = ListCounter.countText(it)

      println("Code: " + countCode1)
      println("Text: " + countText1)

      countCode += countCode1
      countText += countText1
    }

    println(countCode)
    println(countText)
    println(countCode - countText)
  }

}
