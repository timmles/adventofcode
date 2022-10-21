package day1

class D1Part1 {

    fun execute(input: String): Int {
        var sum = 0

        for (charIndex in input.indices) {
            val sut: Int = Character.getNumericValue(input[charIndex])
            val next: Int = if ((charIndex + 1) != input.length) {
                Character.getNumericValue(input[charIndex + 1])
            } else {
                Character.getNumericValue(input[0])
            }

            if (sut == next) sum += sut
        }

        return sum
    }
}

class D1Part2 {

    fun execute(input: String): Int {
        var sum = 0

        val halfwayJump = input.length / 2

        for (charIndex in input.indices) {
            val sut: Int = Character.getNumericValue(input[charIndex])
            val next: Int

            val index = (charIndex + halfwayJump) % input.length
            next = Character.getNumericValue(input[index])

            if (sut == next) sum += sut
        }

        return sum
    }
}