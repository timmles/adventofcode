package year2020.day12

import kotlin.math.abs

class Ship2(val input: List<String>) {
  private var x = 0
  private var y = 0
  private var waypointX = 10
  private var waypointY = 1

  fun followInstructions(): Int {
    input.forEach {
      val direction = it.substring(0, 1)
      val value = it.substring(1).toInt()

      when (direction) {
        "N", "S", "E", "W" -> { move(direction, value) }
        "F" -> { x += waypointX * value; y += waypointY * value }
        "L", "R" -> { rotate(direction, value) }
      }
    }

    return abs(x) + abs(y)
  }

  private fun move(direction: String, value: Int) {
    when (direction) {
      "N" -> { waypointY += value }
      "S" -> { waypointY -= value }
      "E" -> { waypointX += value }
      "W" -> { waypointX -= value }
    }
  }

  private fun rotate(rotate: String, value: Int) {
    repeat(value / 90) {
      when (rotate) {
        "R" -> waypointX = waypointY.also { waypointY = -waypointX }
        "L" -> waypointX = -waypointY.also { waypointY = waypointX }
      }
    }
  }
}

