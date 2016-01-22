package day11

fun main(args: Array<String>) {
    val passwordGenerator = PasswordGenerator()
    var password = "hepxxyzz"
    //    var password = "hepxxyzz"
    do {
        password = passwordGenerator.incrementPassword(password)
    } while(! passwordGenerator.validate(password))

    println(password)
}

class PasswordGenerator {

    val alphabet = "abcdefghijklmnopqrstuvwxyz"

    fun incrementPasswordViaHack(current: String): String {
        val last = current.last()
        val indexInAlphabet = alphabet.indexOf(last)
        val prefixPass = current.dropLast(1)

        if (alphabet.last() == last) {
            return incrementPassword(prefixPass) + alphabet.first()
        } else {
            return prefixPass + alphabet[indexInAlphabet + 1]
        }
    }

    fun incrementPassword(current: String): String {
        return incrementPassword(current, 1)
    }

    fun incrementPassword(current: String, increment: Int): String {
        var currentAsInt = BaseConversion.toBase10(current)
        currentAsInt += increment

        return BaseConversion.toBase26(currentAsInt)
    }

    fun validate(password: String): Boolean {
        return hasStraight(password) && hasValidChars(password) && hasPairs(password)
    }

    fun hasStraight(password: String): Boolean {
        return Regex("abc|bcd|cde|def|efg|fgh|ghi|hij|ijk|jkl|klm|lmn|mno|nop|opq|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz").containsMatchIn(password)
    }

    private fun hasValidChars(password: String): Boolean {
        return Regex("i|o|l").containsMatchIn(password).not()
    }

    private fun hasPairs(password: String): Boolean {
        return Regex("(.)\\1").findAll(password).count() >= 2
    }
}

object BaseConversion {
    fun toBase26(input: Long): String {
        var number = Math.abs(input)
        val base = 26
        var s = ""

        do {
            s += toChar(number % base)
            number /= base
        } while(number > 0)

        return s.reversed()

    }

    fun toBase10(input: String): Long {
        val base = 26
        var s: Long = 0

        input.reversed().forEachIndexed { index, char ->
            s += toNum(char) * Math.pow(base.toDouble(), index.toDouble()).toLong()
        }

        return s
    }

    fun toNum(char: Char): Long {
        val num = char.toLong() - 'a'.toLong()

        return num
    }

    fun toChar(long: Long): Char {
        val l = long + 'a'.toLong()
        return l.toChar()
    }
}



