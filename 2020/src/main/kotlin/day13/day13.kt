package year2020.day13

class Placeholder() {

  fun part1(input: List<String>): Int {
    val departEstimate = input[0].toInt()
    val map = input[1].split(',').filter { it != "x" }.map { it.toInt() }
      .map { it to (it - (departEstimate % it)) }
    val minBy = map.minBy { it.second }!!
    return minBy.first * minBy.second
  }

  fun part2_bf_intersect(input: List<String>): Long {
    var startOffset = 0L
    val batchSize = 1_000_000L
    var countOffset = 0L

    while (true) {
      val busses = arrayListOf<List<Long>>()
      input[1].split(',').forEach {
        if (it == "x") countOffset++
        else {
          val current = it.toLong()
          val specificOffset = (startOffset / current) * current
          busses.add(((specificOffset - countOffset)..(batchSize + startOffset) step current).toList())
          countOffset++
        }
      }
      countOffset = 0L
      startOffset += batchSize

      val reduce = busses.map { it.toSet() }.reduce { acc, set -> acc.intersect(set) }
      if (reduce.isNotEmpty()) return reduce.first()
    }
  }

  fun part2_bf_modulus(input: List<String>, offset: Long): Long {
    val input = input[1]
      .split(',')
      .mapIndexed { index, it ->
        if (it == "x") null
        else Pair(it.toLong(), index)
      }.filterNotNull()

    val largest = input.maxBy { it.first }!!

    var departTime: Long = (offset/largest.first)*largest.first + (largest.first - largest.second.toLong())
    outer@ while (true) {
      for (el in input) {
        if ((departTime + el.second) % el.first != 0L) {
          departTime += largest.first
          continue@outer
        }
      }
      break
    }
    return departTime
  }

  private fun busIdAndOffset(input: List<String>) = input[1]
    .split(',')
    .mapIndexed { index, it ->
      if (it == "x") null
      else Pair(it.toLong(), index)
    }.filterNotNull()

  /* returns x where (a * x) % b == 1 */
  fun multInv(a: Long, b: Long): Long {
    if (b == 1L) return 1L
    var aa = a
    var bb = b
    var x0 = 0L
    var x1 = 1L
    while (aa > 1) {
      val q = aa / bb
      var t = bb
      bb = aa % bb
      aa = t
      t = x0
      x0 = x1 - q * x0
      x1 = t
    }
    if (x1 < 0) x1 += b
    return x1
  }

  fun chineseRemainder(n: LongArray, a: LongArray): Long {
    val prod = n.fold(1L) { acc, i -> acc * i }
    var sum = 0L
    for (i in 0 until n.size) {
      val p = prod / n[i]
      sum += a[i] * multInv(p, n[i]) * p
    }
    return sum % prod
  }

  fun part2_crm(input: List<String>): Long {
    val input = input[1]
      .split(',')
      .mapIndexed { index, it ->
        if (it == "x") null
        else Pair(it.toLong(), if (index == 0) 0 else it.toLong() - index)
      }.filterNotNull()


    return chineseRemainder(input.map { it.first }.toLongArray(), input.map { it.second }.toLongArray())
  }
}

