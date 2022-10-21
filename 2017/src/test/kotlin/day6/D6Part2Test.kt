package day6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class D6Part2Test {
    @Test
    fun GIVEN_0270_WHEN_reallocate_THEN_4() {
        Assertions.assertEquals(4, D6Part1(arrayOf(0, 2, 7, 0)).timeToStable())
    }

    @Test
    fun GIVEN_actual_WHEN_reallocate_THEN_2765() {
        Assertions.assertEquals(2765, D6Part1(arrayOf(10, 3, 15, 10, 5, 15, 5, 15, 9, 2, 5, 8, 5, 2, 3, 6)).timeToStable())
    }

}