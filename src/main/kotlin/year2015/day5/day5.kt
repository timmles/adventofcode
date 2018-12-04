package year2015.day5

import common.Common

object NaughtyNice {

    fun isNaughtyNice(input: String): String {
        return if (isNice(input)) "Nice" else "Naughty"
    }

    fun isNice(input: String): Boolean {
        val notContain = isNotContain(input)
        val double = isDouble(input)
        val threeVowels = isThreeVowels(input)

//        println("" + notContain + double + threeVowels)
        return notContain && double && threeVowels
    }

    fun isNewNice(input:String): Boolean {
        return isPair(input) && isRepeat(input)
    }

    private fun isThreeVowels(input: String): Boolean {
        var count = 0

        count += input.filter { it == 'a' }.count()
        count += input.filter { it == 'e' }.count()
        count += input.filter { it == 'i' }.count()
        count += input.filter { it == 'o' }.count()
        count += input.filter { it == 'u' }.count()

        return count >= 3
    }

    private fun isDouble(input: String): Boolean {
        return Regex("([A-Za-z])\\1").containsMatchIn(input)
    }

    private fun isPair(input: String): Boolean {
        return Regex("(([A-Za-z])([A-Za-z])).*\\1").containsMatchIn(input)
    }

    private fun isRepeat(input: String): Boolean {
        return Regex("([A-Za-z]).\\1").containsMatchIn(input)
    }

    private fun isNotContain(input: String): Boolean {
        return !input.contains("ab") &&
               !input.contains("cd") &&
               !input.contains("pq") &&
               !input.contains("xy")
    }
}

fun main(args: Array<String>) {
//    println(NaughtyNice().isNaughtyNice("ugknbfddgicrmopn"))
//    println(NaughtyNice().isNaughtyNice("aaa"))
//    println(NaughtyNice().isNaughtyNice("jchzalrnumimnmhp"))
//    println(NaughtyNice().isNaughtyNice("haegwjzuvuyypxyu"))
//    println(NaughtyNice().isNaughtyNice("dvszwmarrgswjxmb"))

    var count = 0;
    val dayfiveInput = Common.getFile("day5_input.txt")

    dayfiveInput.forEachLine {
        if (NaughtyNice.isNewNice(it)) count++
    }

    println(count)

}