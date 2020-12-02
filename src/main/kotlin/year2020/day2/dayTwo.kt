package year2020.day2

abstract class PasswordDatabase(input: List<String>) {
  var database: List<Password> = input.map { constructType(it) }

  abstract fun constructType(s: String): Password

  fun countValid(): Int {
    return database.filter { it.valid() }.count()
  }
}

class SledPasswordDatabase(input: List<String>) : PasswordDatabase(input) {
  override fun constructType(s: String): Password {
    return SledPassword(s)
  }
}

class TobogganPasswordDatabase(input: List<String>) : PasswordDatabase(input) {
  override fun constructType(s: String): Password {
    return TobogganPassword(s)
  }
}

interface Password {
  fun valid(): Boolean
}

class SledPassword(s: String) : Password {
  val intRange: IntRange
  val passwordChar: Char
  val password: String

  init {
    val split = s.split(" ")

    val rangeSplit = split[0].split("-")
    intRange = IntRange(rangeSplit[0].toInt(), rangeSplit[1].toInt())

    passwordChar = split[1][0]

    password = split[2]
  }

  override fun valid(): Boolean {
    return intRange.contains(password.count { it == passwordChar })
  }

}

class TobogganPassword(s: String) : Password {
  val charOne: Char
  val charTwo: Char
  val passwordPolicy: Char

  init {
    val split = s.split(" ")

    val rangeSplit = split[0].split("-")
    val first = rangeSplit[0].toInt()
    val second = rangeSplit[1].toInt()

    charOne = split[2][first - 1]
    charTwo = split[2][second - 1]

    passwordPolicy = split[1][0]
  }

  override fun valid(): Boolean {
    return (charOne == passwordPolicy).xor(charTwo == passwordPolicy)
  }

}
