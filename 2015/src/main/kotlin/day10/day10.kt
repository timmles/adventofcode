package year2015.day10

fun main(args: Array<String>) {
    val lookAndSay = LookAndSay()

    var input = "1113122113"

    for (i in 1..50) {
        input = lookAndSay.process(input)
//        println("$i :: $input")
    }

//    println(input)
    println("count is ${input.length}")
}

class LookAndSay {
    private val regex = Regex("([0-9])(\\1)*")
//    private val regex = Regex("([0-9])*")

    fun process(input : String) : String {
        val stringBuilder = StringBuilder()

        regex.findAll(input, 0).forEach {
            stringBuilder.append(it.value.length).append(it.value.get(0))
        }

        return stringBuilder.toString()
    }

}
