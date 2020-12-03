package year2019.day5

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

class DayFiveKtTest {

  @Test
  fun testExamples1() {
    assertEquals("3500,9,10,70,2,3,11,0,99,30,40,50", IntCode("1,9,10,3,2,3,11,0,99,30,40,50").status())
    assertEquals("2,0,0,0,99", IntCode("1,0,0,0,99").status())
    assertEquals("2,3,0,6,99", IntCode("2,3,0,3,99").status())
    assertEquals("2,4,4,5,99,9801", IntCode("2,4,4,5,99,0").status())
    assertEquals("30,1,1,4,2,5,6,0,99", IntCode("1,1,1,4,99,5,6,0,99").status())
    assertEquals("1002,4,3,4,99", IntCode("1002,4,3,4,33").status())
  }

  @Test
  fun test() {
    assertEquals(11933517, IntCode(Common.getFile("year2019/day5.txt").readLines().first(), 1).output)
  }

  @Test
  fun test2() {
    assertEquals(10428568, IntCode(Common.getFile("year2019/day5.txt").readLines().first(), 5).output)
  }

  @Test
  fun equalEight() {
    assertEquals(0, IntCode("3,9,8,9,10,9,4,9,99,-1,8", 7).output)
    assertEquals(1, IntCode("3,9,8,9,10,9,4,9,99,-1,8", 8).output)
    assertEquals(0, IntCode("3,9,8,9,10,9,4,9,99,-1,8", 9).output)

    assertEquals(0, IntCode("3,3,1108,-1,8,3,4,3,99", 7).output)
    assertEquals(1, IntCode("3,3,1108,-1,8,3,4,3,99", 8).output)
    assertEquals(0, IntCode("3,3,1108,-1,8,3,4,3,99", 9).output)
  }

  @Test
  fun lessEight() {
    assertEquals(1, IntCode("3,9,7,9,10,9,4,9,99,-1,8", 7).output)
    assertEquals(0, IntCode("3,9,7,9,10,9,4,9,99,-1,8", 8).output)
    assertEquals(0, IntCode("3,9,7,9,10,9,4,9,99,-1,8", 9).output)

    assertEquals(1, IntCode("3,3,1107,-1,8,3,4,3,99", 7).output)
    assertEquals(0, IntCode("3,3,1107,-1,8,3,4,3,99", 8).output)
    assertEquals(0, IntCode("3,3,1107,-1,8,3,4,3,99", 9).output)
  }

  @Test
  fun isZero() {
    assertEquals(0, IntCode("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9", 0).output)
    assertEquals(1, IntCode("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9", 7).output)

    assertEquals(0, IntCode("3,3,1105,-1,9,1101,0,0,12,4,12,99,1", 0).output)
    assertEquals(1, IntCode("3,3,1105,-1,9,1101,0,0,12,4,12,99,1", 7).output)
  }

  @Test
  fun isEightToThousand() {
    assertEquals(999, IntCode("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99", 7).output)
    assertEquals(1000, IntCode("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99", 8).output)
    assertEquals(1001, IntCode("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99", 9).output)
  }
}
