package day5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class D5Part2Test {
    @Test
    fun GIVEN_0_3_0_1_neg3_WHEN_calculate_THEN_10() {
        val ints = arrayOf(0, 3, 0, 1, -3)

        Assertions.assertEquals(10, D5Part2().execute(ints))
    }

    @Test
    fun GIVEN_actual_WHEN_calculate_THEN_318883() {
        val url: String = ClassLoader.getSystemClassLoader().getResource("D5.txt").file

        val ints = File(url).readLines().map { input -> input.toInt() }

        Assertions.assertEquals(23948711, D5Part2().execute(ints.toTypedArray()))
    }

}