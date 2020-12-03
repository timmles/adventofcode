package year2019.day1

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class DayOneTest {

  @Test
  fun calculateModuleFuel() {
    assertEquals(2, calculateFuel(12), "calculateMass12 : calculate : fail")
    assertEquals(2, calculateFuel(14), "calculateMass12 : calculate : fail")
    assertEquals(654, calculateFuel(1969), "calculateMass12 : calculate : fail")
    assertEquals(33583, calculateFuel(100756), "calculateMass12 : calculate : fail")
  }

  @Test
  fun calculateFuelFuel() {
    assertEquals(2, calculateFuelFuel(14), "calculateMass12 : calculate : fail")
    assertEquals(966, calculateFuelFuel(1969), "calculateMass12 : calculate : fail")
    assertEquals(50346, calculateFuelFuel(100756), "calculateMass12 : calculate : fail")
  }

  @Test
  fun sumQ1() {
    val sumByDouble = Common.getFile("year2019/day1.txt").readLines().sumByDouble { calculateFuel(it.toLong()).toDouble() }
    assertEquals(3265923.0, sumByDouble, "calculateMass12 : calculate : fail")
  }

  @Test
  fun sumQ2() {
    val sumByDouble = Common.getFile("year2019/day1.txt").readLines().sumByDouble { calculateFuelFuel(it.toLong()).toDouble() }
    assertEquals(4896020.0, sumByDouble, "calculateMass12 : calculate : fail")
  }

}
