package day4

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class D4Part2Test {
    @Test
    fun GIVEN_passphase_WHEN_validated_THEN_correct() {
        val a = D4Part2.validate("abcde fghij")
        val b = D4Part2.validate("a ab abc abd abf abj")
        val c = D4Part2.validate("iiii oiii ooii oooi oooo")

        val d = D4Part2.validate("abcde xyz ecdab")
        val e = D4Part2.validate("oiii ioii iioi iiio")

        Assertions.assertTrue(a)
        Assertions.assertTrue(b)
        Assertions.assertTrue(c)

        Assertions.assertFalse(d)
        Assertions.assertFalse(e)
    }

    @Test
    fun GIVEN_actual_WHEN_validated_THEN_correct() {
        val url: String = ClassLoader.getSystemClassLoader().getResource("D4.txt").file

        val input = File(url).readLines()
        var count = 0;

        for (line in input) {
            if (D4Part2.validate(line)) count++
        }

        Assertions.assertEquals(208, count)
    }

}