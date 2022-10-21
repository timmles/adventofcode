package day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class D3Part2Test {

    @Test
    fun GIVEN_289326_WHEN_calculate_THEN_419() {
        Assertions.assertEquals(295229, D3Part2().execute(289326))
    }


}