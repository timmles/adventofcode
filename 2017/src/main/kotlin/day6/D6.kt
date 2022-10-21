package day6

class D6Part1(memoryBlocks: Array<Int>) {
    var history: List<String> = ArrayList<String>()
    var memoryBlocks = memoryBlocks

    fun firstToStable(): Int {
        reallocate()
        return history.size
    }

    fun timeToStable(): Int {
        reallocate()

        val last = history.last()

        history = ArrayList<String>()
        history.plus(last)

        reallocate()

        return history.size
    }

    private fun reallocate() {
        history = history.plus(memoryBlocks.joinToString(""))

        while (true) {
            val reallocateOnce = reallocateOnce(memoryBlocks)
            if (history.contains(reallocateOnce.joinToString(""))) {
                break
            } else {
                history = history.plus(reallocateOnce.joinToString(""))
            }
        }
    }

    private fun reallocateOnce(memoryBlocks: Array<Int>): Array<Int> {
        var indexOfFirstMax = memoryBlocks.indexOf(memoryBlocks.max())

        var memoryToReallocate = memoryBlocks[indexOfFirstMax]
        memoryBlocks[indexOfFirstMax] = 0

        while (memoryToReallocate > 0) {
            memoryToReallocate--
            indexOfFirstMax++
            if (indexOfFirstMax >= memoryBlocks.size) indexOfFirstMax = 0

            memoryBlocks[indexOfFirstMax] += 1
        }

        return memoryBlocks;
    }
}

class D6Part2 {
    fun reallocate(memoryBlocks: Array<Int>): Int {
        var history: List<String> = ArrayList<String>()
        history = history.plus(memoryBlocks.joinToString(""))

        while (true) {
            val reallocateOnce = reallocateOnce(memoryBlocks)
            if (history.contains(reallocateOnce.joinToString(""))) {
                break
            } else {
                history = history.plus(reallocateOnce.joinToString(""))
            }
        }

//        while (true) {
//            val reallocateOnce = reallocateOnce(memoryBlocks)
//            if (history.contains(reallocateOnce.joinToString(""))) {
//                break
//            } else {
//                history = history.plus(reallocateOnce.joinToString(""))
//            }
//        }

        return history.size
    }

    private fun reallocateOnce(memoryBlocks: Array<Int>): Array<Int> {
        var indexOfFirstMax = memoryBlocks.indexOf(memoryBlocks.max())

        var memoryToReallocate = memoryBlocks[indexOfFirstMax]
        memoryBlocks[indexOfFirstMax] = 0

        while (memoryToReallocate > 0) {
            memoryToReallocate--
            indexOfFirstMax++
            if (indexOfFirstMax >= memoryBlocks.size) indexOfFirstMax = 0

            memoryBlocks[indexOfFirstMax] += 1
        }

        return memoryBlocks;
    }
}