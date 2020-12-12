package year2020.day12

import kotlin.math.abs

class Ship(val input: List<String>) {
  var x = 0
  var y = 0
  internal var currentDirection = "E"

  fun followInstructions(): Int {
    input.forEach {
      var direction = it.substring(0, 1)
      val value = it.substring(1).toInt()

//      Action N means to move north by the given value.
//      Action S means to move south by the given value.
//      Action E means to move east by the given value.
//      Action W means to move west by the given value.
//      Action L means to turn left the given number of degrees.
//      Action R means to turn right the given number of degrees.
//      Action F means to move forward by the given value in the direction

      if (direction == "F") direction = currentDirection

      when (direction) {
        "N", "S", "E", "W" -> { move(direction, value) }
        "F" -> { move(currentDirection, value) }
        "L", "R" -> { rotate(direction, value) }
      }
    }

    return Math.abs(x) + Math.abs(y)
  }

  private fun move(direction: String, value: Int) {
    when (direction) {
      "N" -> { y += value }
      "S" -> { y -= value }
      "E" -> { x += value }
      "W" -> { x -= value }
    }
  }

  internal fun rotate(direction: String, value: Int) {
    val directions = arrayOf("N", "E", "S", "W")

    val indexCurrent = directions.indexOf(currentDirection)
    val indexShift = value / 90

    val newDirection: Int = when (direction) {
      "R" -> { (indexCurrent + indexShift) % 4 }
      "L" -> {
        val i = (indexCurrent - indexShift) + 16
        Math.abs(i) % 4 }
      else -> throw Error("no direction")
    }

    currentDirection = directions[newDirection]
  }
}

