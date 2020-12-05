package year2020.day5

class Aeroplane(seatsInput: List<String>) {
  val rowBound = 127
  val columnBound = 8
  val seats: Map<String, Int>

  init {
      seats = seatsInput.map { it to this.seatId(it) }.toMap()
  }

  fun seatId(input: String): Int {
    val row = binarySearch(input.substring(0, 7), rowBound)
    val column = binarySearch(input.substring(7, 10), columnBound)
    return row * 8 + column
  }

  fun highestSeatId(): Int {
    return seats.values.maxOrNull()!!
  }

  fun searchEmptySeat(): Int {
    val values = seats.values.toList().sorted()
    values.forEachIndexed { index, i ->
      if (values[index] + 2 == values[index+1])
        return values[index] + 1
    }
    throw Error("Plane is full")
  }

  internal fun binarySearch(actions: String, size: Int): Int {
    var lowerBound = 0.0
    var upperBound = size.toDouble()
    actions.toCharArray().forEach {
      when (it) {
        'F', 'L' -> upperBound -= Math.ceil((upperBound-lowerBound) /2)
        'B', 'R' -> lowerBound += Math.ceil((upperBound-lowerBound)/2)
      }
    }

    return lowerBound.toInt()
  }
}

