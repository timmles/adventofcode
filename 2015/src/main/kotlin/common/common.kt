package common

import java.io.File

object Common {
    fun getFile(s: String): File {
        val url: String = ClassLoader.getSystemClassLoader().getResource(s).file
        return File(url)
    }
}