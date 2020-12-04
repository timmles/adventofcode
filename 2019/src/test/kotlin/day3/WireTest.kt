package year2019.day3

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class WireTest {
  @Test
  fun test() {
    val wire1 = Wire("R8,U5,L5,D3")
    val wire2 = Wire("U7,R6,D4,L4")

    assertEquals(6, manhathan(wire1, wire2))
  }

  @Test
  fun test2() {
    val wire1 = Wire("R75,D30,R83,U83,L12,D49,R71,U7,L72")
    val wire2 = Wire("U62,R66,U55,R34,D71,R55,D58,R83")
    assertEquals(159, manhathan(wire1, wire2))
  }

  @Test
  fun test3() {
    val wire1 = Wire("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51")
    val wire2 = Wire("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")
    assertEquals(135, manhathan(wire1, wire2))
  }

  @Test
  fun q1() {
    val readLines = Common.getFile("day3.txt").readLines()
    val wire1 = Wire(readLines[0])
    val wire2 = Wire(readLines[1])
    assertEquals(207, manhathan(wire1, wire2))
  }

  @Test
  fun test2Delay() {
    val wire1 = Wire("R75,D30,R83,U83,L12,D49,R71,U7,L72")
    val wire2 = Wire("U62,R66,U55,R34,D71,R55,D58,R83")
    assertEquals(610, delay(wire1, wire2))
  }

  @Test
  fun test3Delay() {
    val wire1 = Wire("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51")
    val wire2 = Wire("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")
    assertEquals(410, delay(wire1, wire2))
  }

  @Test
  fun q2() {
    val readLines = Common.getFile("day3.txt").readLines()
    val wire1 = Wire(readLines[0])
    val wire2 = Wire(readLines[1])
    assertEquals(21196, delay(wire1, wire2))
  }
}
