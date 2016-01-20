package day10

import org.junit.Test

import org.junit.Assert.*

class LookAndSayTest {

    @Test
    fun given_1_expect_11() {
        val lookAndSay: LookAndSay = LookAndSay()
        assertEquals("11", lookAndSay.process("1"))
    }

    @Test
    fun given_111221_expect_312211() {
        val lookAndSay: LookAndSay = LookAndSay()
        assertEquals("312211", lookAndSay.process("111221"))
    }

}