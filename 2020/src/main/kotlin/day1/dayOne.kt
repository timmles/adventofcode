package year2020.day1

fun findAndMultiplyPairs(inputs: List<Int>): Int {
  var pair: Pair<Int, Int> = findPair(inputs)
  return pair.first * pair.second
}

fun findAndMultiplyTriples(inputs: List<Int>): Int {
  var triple: Triple<Int, Int, Int> = findTriple(inputs)
  return triple.first * triple.second * triple.third
}

internal fun findPair(inputs: List<Int>): Pair<Int, Int> {
  inputs.forEachIndexed { index, value ->
    for (i in index until inputs.size) {
      if (inputs[i] + value == 2020)
        return Pair(inputs[i], value)
    }
  }

  throw Error("could not find pair")
}

internal fun findTriple(inputs: List<Int>): Triple<Int, Int, Int> {
  inputs.forEachIndexed { index, value ->
    for (x in index until inputs.size) {
      for (y in x until inputs.size) {
        if (inputs[x] + inputs[y] + value == 2020)
          return Triple(inputs[x], inputs[y], value)
      }
    }
  }

  throw Error("could not find pair")
}
