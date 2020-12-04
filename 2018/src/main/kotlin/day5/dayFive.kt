package year2018.day5

class DayFive {
    fun react(input: String): String {
        var reprocess:Boolean
        var removeNext = false
        var processedInput: String = input

        do {
            reprocess = false
            processedInput = processedInput.filterIndexed { index, c ->
                if (removeNext) {
                    removeNext = false
                    false
                } else if (index == processedInput.lastIndex) {
                true
                } else if (processedInput[index+1] == toggleCase(c)) {
                    removeNext = true
                    reprocess = true
                    false
                } else {
                    true
                }
            }

        } while (reprocess)

        return processedInput
    }

    private fun toggleCase(char: Char): Char {
        if (char.isLowerCase()) return char.toUpperCase()
        return char.toLowerCase()
    }
}

