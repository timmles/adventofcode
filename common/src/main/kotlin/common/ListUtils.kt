package common

fun <E> List<E>.customSplit(split: E): List<List<E>> {
  val indexOf = this.indices.filter { this[it] == split }.toMutableList()
  indexOf.add(this.size)

  var previousIndex: Int = 0
  return indexOf.map { index ->
    val subList: List<E> = this.subList(previousIndex, index)
    previousIndex = index + 1
    subList
  }
}
