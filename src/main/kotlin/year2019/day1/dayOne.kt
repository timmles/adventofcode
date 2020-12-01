package year2019.day1

fun calculateFuel(module: Long): Long {
  return Math.max(0, Math.floor(module.toDouble() / 3).toLong() - 2)
}

fun calculateFuelFuel(module: Long): Long {
  val moduleFuel = calculateFuel(module)
  return moduleFuel + calculateFuelLoop(moduleFuel)
}

internal fun calculateFuelLoop(weight: Long): Long {
  if (weight > 0) {
    val fuel = calculateFuel(weight)
    return fuel + calculateFuelLoop(fuel)
  } else {
    return 0
  }
}

