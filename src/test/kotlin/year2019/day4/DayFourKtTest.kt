package year2019.day4

import org.junit.Test
import kotlin.test.assertEquals


class DayFourKtTest {

  @Test
  fun example1() {
    assertEquals(true, validate("111111", LongRange(0, 9999999999)))
    assertEquals(false, validate("223450", LongRange(0, 9999999999)))
    assertEquals(false, validate("123789", LongRange(0, 9999999999)))
  }

  @Test
  fun example2() {
    assertEquals(true, validateV2NoRange("112233"))
    assertEquals(false, validateV2NoRange("123444"))
    assertEquals(false, validateV2NoRange("444555"))
    assertEquals(true, validateV2NoRange("111122"))
    assertEquals(false, validateV2NoRange("111123"))
  }

  @Test
  fun question1() {
    var count = 0

    for (i in 134564..585159) {
      if(validateNoRange(i.toString())) {
        count++
      }
    }

    assertEquals(1929, count)
  }

  @Test
  fun question2() {
    var count = 0

    for (i in 134564..585159) {
      if(validateV2NoRange(i.toString())) {
        count++
      }
    }

    assertEquals(1306, count)
  }
}
