package day6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class D6Part1Test {
    @Test
    fun GIVEN_0270_WHEN_reallocate_THEN_5() {
        Assertions.assertEquals(5, D6Part1(arrayOf(0, 2, 7, 0)).firstToStable())
    }

    @Test
    fun GIVEN_actual_WHEN_reallocate_THEN_14029() {
        Assertions.assertEquals(14029, D6Part1(arrayOf(10,3,15,10,5,15,5,15,9,2,5,8,5,2,3,6)).firstToStable())
    }

}