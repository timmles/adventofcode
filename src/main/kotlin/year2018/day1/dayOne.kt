package year2018.day1

class DayOne {
    fun drift(initialFreq: Int, drift: List<Int>): Int {
        return drift.sum() + initialFreq
    }

    fun findFirstRepeatedFrequency(initialFreq: Int, drift: List<Int>): Int {
        val frequencies: MutableSet<Int> = mutableSetOf(initialFreq)

        var currentFreq = initialFreq
        var count = 0

        while (true) {
            val it = drift.get(count % drift.size)

            currentFreq += it
            val add: Boolean = frequencies.add(currentFreq)
            if (add) {
                count++
            } else {
                return currentFreq
            }
        }
    }

}