package day4

import org.junit.Assert.*
import org.junit.Test

class MD5BuilderTest {
    @Test
    fun testABC() {
        var s = "abcdef609043";
        val md5 = MD5Builder()
        assertEquals("000001dbbfa3a5c83a2d506429c7b00e", md5.addPadding(md5.generateMD5Hash(s)))
    }

    @Test
    fun testPQR() {
        var s = "pqrstuv1048970";
        val md5 = MD5Builder()
        assertEquals("000006136ef2ff3b291c85725f17325c", md5.addPadding(md5.generateMD5Hash(s)))
    }
}