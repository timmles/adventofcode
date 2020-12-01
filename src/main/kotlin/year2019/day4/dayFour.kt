package year2019.day4

fun validate(password: String, range: LongRange): Boolean {
  if (!rangeRule(password, range)) return false
  return validateNoRange(password)
}

fun validateNoRange(password: String): Boolean {
  if (!lengthRule(password)) return false
  if (!adjacentRule(password)) return false
  if (!acendingRule(password)) return false

  return true
}

fun validateV2NoRange(password: String): Boolean {
  if (!lengthRule(password)) return false
  if (!adjacentButNotMoreRule(password)) return false
  if (!acendingRule(password)) return false

  return true
}

fun lengthRule(password: String): Boolean {
  return password.length == 6
}

fun rangeRule(password: String, range: LongRange): Boolean {
  return range.contains(password.toLong())
}

fun adjacentRule(password: String): Boolean {
  password.forEachIndexed { index, c ->
    if (index + 1 < password.length && password[index + 1].equals(c)) return true
  }

  return false
}

fun adjacentButNotMoreRule(password: String): Boolean {
  var skip = 0
  password.forEachIndexed { index, c ->
    if (skip == 0) {
      var count = 0
      password.substring(index).forEach lit@{
        if (it == c) count++ else return@lit
      }
      if (count == 2) return true else skip += count - 1
    } else {
      skip--
    }
  }

  return false
}

fun acendingRule(password: String): Boolean {
  password.forEachIndexed { index, c ->
    if (index + 1 < password.length && password[index + 1].toInt() < c.toInt()) return false
  }

  return true
}
