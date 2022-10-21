package day2

class Second {

    fun execute(input: Array<String>): Int {
        val output: List<Int> = input.map { string -> checksum(string) }

        return output.sum()
    }

    private fun checksum(string: String): Int {
        val map: List<Int> = transform(string)

        val min = map.min()
        val max = map.max()

        if (max != null && min != null) {
            return (max - min)
        }

        return 0
    }

    private fun transform(string: String): List<Int> {
        val split: List<String> = string.split(' ')
        return split.map { input -> input.toInt() }
    }
}

class D2Part2 {

    fun execute(input: Array<String>): Int {
        val output: List<Int> = input.map { string -> divisible(string) }

        return output.sum()
    }

    private fun divisible(string: String): Int {
        val map: List<Int> = transform(string)

        var a = 0
        var b = 0

        loop@ for (num in map) {
            for (divisible in map.minusElement(num)) {
                if (autoMod(divisible, num) == 0) {
                    a = num
                    b = divisible
                    break@loop
                }
            }
        }

        return autoDivide(a, b)
    }

    private fun autoDivide(a: Int, b: Int): Int {
        return maxOf(a,b) / minOf(a,b)
    }

    private fun autoMod(a: Int, b: Int): Int {
        return maxOf(a,b) % minOf(a,b)
    }

    private fun transform(string: String): List<Int> {
        val split: List<String> = string.split(' ')
        return split.map { input -> input.toInt() }
    }
}
