package year2020.day12

import kotlin.math.abs

class Ship(val input: List<String>) {
  private var x = 0
  private var y = 0
  private var currentDirection = "E"

  fun followInstructions(): Int {
    input.forEach {
      val direction = it.substring(0, 1)
      val value = it.substring(1).toInt()

      when (direction) {
        "N", "S", "E", "W" -> { move(direction, value) }
        "F" -> { move(currentDirection, value) }
        "L", "R" -> { rotate(direction, value) }
      }
    }

    return abs(x) + abs(y)
  }

  private fun move(direction: String, value: Int) {
    when (direction) {
      "N" -> { y += value }
      "S" -> { y -= value }
      "E" -> { x += value }
      "W" -> { x -= value }
    }
  }

  private fun rotate(direction: String, value: Int) {
    val directions = arrayOf("N", "E", "S", "W")

    val indexCurrent = directions.indexOf(currentDirection)
    val indexShift = value / 90

    val newDirection: Int = when (direction) {
      "R" -> indexCurrent + indexShift
      "L" -> indexCurrent - indexShift
      else -> throw Error("no direction")
    }

    currentDirection = directions[(newDirection + 4) % 4] // runs the risk if indexShift is smaller than -4
  }
}

