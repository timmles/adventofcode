package year2020.day2

class SledPasswordDatabase(input: List<String>) {
  var database: List<SledPassword> = input.map { SledPassword(it) }

  fun countValid(): Int {
    return database.filter { it.valid() }.count()
  }
}

class SledPassword(s: String) {
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

  fun valid(): Boolean {
    return intRange.contains(password.count { it == passwordChar })
  }

}

class TobogganPasswordDatabase(input: List<String>) {
  var database: List<TobogganPassword> = input.map { TobogganPassword(it) }

  fun countValid(): Int {
    return database.filter { it.valid() }.count()
  }
}

class TobogganPassword(s: String) {
  val charOne: Char
  val charTwo: Char
  val passwordPolicy: Char

  init {
    val split = s.split(" ")

    val rangeSplit = split[0].split("-")
    val first = rangeSplit[0].toInt()
    val second = rangeSplit[1].toInt()

    charOne = split[2][first-1]
    charTwo = split[2][second-1]

    passwordPolicy = split[1][0]
  }

  fun valid(): Boolean {
    return (charOne == passwordPolicy).xor(charTwo == passwordPolicy)
  }

}
