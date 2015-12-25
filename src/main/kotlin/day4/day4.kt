package day4

import java.math.BigInteger
import java.security.MessageDigest

class MD5Builder {
    fun generateMD5Hash(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val messageDigest = md.digest(input.toByteArray())
        val number = BigInteger(1, messageDigest)
        return number.toString(16)
    }

    fun addPadding(hashtext: String): String {
        var padding = ""


        while (hashtext.length + padding.length < 32) {
            padding += "0"
        }

        return padding + hashtext
    }
}

fun main(args: Array<String>) {
    var seed = "iwrupvqb";
    val md5 = MD5Builder()

    var suffix = 0;
    do {
        suffix++;
        val generateMD5Hash = md5.generateMD5Hash(seed + suffix)
//        val padded = md5.addPadding(generateMD5Hash)
    } while(generateMD5Hash.length > 26)
//    } while(padded.startsWith("00000"))

    println(seed + suffix)
}

// iwrupvqb346386