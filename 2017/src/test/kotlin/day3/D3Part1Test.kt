package day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class D3Part1Test {
    @Test
    fun GIVEN_1_WHEN_calculate_THEN_0() {
        Assertions.assertEquals(0, D3Part1().execute(1))
    }

    @Test
    fun GIVEN_12_WHEN_calculate_THEN_3() {
        Assertions.assertEquals(3, D3Part1().execute(12))
    }

    @Test
    fun GIVEN_23_WHEN_calculate_THEN_2() {
        Assertions.assertEquals(2, D3Part1().execute(23))
    }

    @Test
    fun GIVEN_1024_WHEN_calculate_THEN_31() {
        Assertions.assertEquals(31, D3Part1().execute(1024))
    }

    @Test
    fun GIVEN_289326_WHEN_calculate_THEN_419() {
        Assertions.assertEquals(419, D3Part1().execute(289326))
    }


}