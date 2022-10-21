package day5

class D5Part1 {

    fun execute(values: Array<Int>): Int {
        var count = 0
        var pointer = 0

        while (pointer < values.size) {
            val instruction = values[pointer]
            values[pointer]++

            pointer += instruction
            count++
        }

        return count
    }
}

class D5Part2 {

    fun execute(values: Array<Int>): Int {
        var count = 0
        var pointer = 0

        while (pointer < values.size) {
            val instruction = values[pointer]

            if (instruction >= 3) {
                values[pointer]--
            } else {
                values[pointer]++
            }

            pointer += instruction
            count++
        }

        return count
    }
}