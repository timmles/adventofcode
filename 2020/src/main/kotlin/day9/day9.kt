package year2020.day9

class XmasCracker() {

  fun findFirstInvalid(preambleSize: Int, input: List<Long>): Long {
    for (index in preambleSize..input.size) {
      if (!valid(input.subList(index - preambleSize ,index), input[index]))
        return input[index]
    }

    throw Error("completely valid")
  }

  fun valid(preamble: List<Long>, match:Long): Boolean {
    // probably doesn't check for where both values are the same
    preamble.forEach {
      if (preamble.minusElement(it).contains(match - it)) return true
    }
    return false
  }

  fun findWeakness(findFirstInvalid: Long, input: List<Long>): Long {
    for (x in 0..input.size) {
      var sum = 0L

      for (y in x..input.size) {
        sum += input[y]
        if (sum == findFirstInvalid) {
          val subList = input.subList(x, y)
          return subList.min()!! + subList.max()!!
        }
        else if (sum > findFirstInvalid)
          break
      }
    }

    return 0
  }
}

