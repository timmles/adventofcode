package year2020.day10

class Placeholder(input: List<Int>) {
  val adapters: List<Int>


  init {
    val tmpInput = input.toMutableList()
    tmpInput.add(0)
    tmpInput.add(tmpInput.max()!! + 3)
    tmpInput.sort()

    adapters = tmpInput.toList()
  }

  fun usingAllAdaptors(): Int {
    var first = 0
    var second = 0
    var third = 0

    for (i in 1 until adapters.size) {
      when (adapters[i] - adapters[i - 1]) {
        1 -> first++
        2 -> second++
        3 -> third++
      }
    }

    return first * third
  }

  fun possibleAdaptors(): Long {
    val memTable = LongArray(adapters.size)
    memTable[adapters.lastIndex] = 1

    for (index in adapters.lastIndex-1 downTo 0) { // run for the back to the front
      val maxSize = Math.min(index + 4, adapters.lastIndex) //just make sure we don't get index out of bounds at the beginning
      memTable[index] = (index + 1..maxSize) // take the next 3 adaptors
        .filter { adapters[it] <= adapters[index] + 3 } // filter where value is +3 or less
        .map { memTable[it] } // map to the memoized value (i.e. the precalculated paths to the end)
        .sum() // sum them together
    }

    return memTable[0] // return the memoized value for the first adaptor
  }
}

