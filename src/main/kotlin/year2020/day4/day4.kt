package year2020.day4

class PassportScanner(val input: List<String>) {
  var passports: MutableList<Passport> = mutableListOf()

  init {
    var tmp = mutableListOf<String>()
    input.forEach {
      if (it.isNotBlank()) {
        tmp.add(it)
      }
      else {
        passports.add(Passport(tmp))
        tmp.clear()
      }
    }
    // for the last batch before EOF
    passports.add(Passport(tmp))
    tmp.clear()
  }

  fun validateNotNull(): Int {
    return passports.count { it.validateNotNull() }
  }

  fun validateContents(): Int {
    return passports.count { it.validateContents() }
  }
  class Passport(val input: List<String>) {
    val properties: Map<String, String>

    init {
      properties = input.flatMap { it.split(' ') }.map {
        val split = it.split(':')
        split[0] to split[1]
      }.toMap()
    }

    fun validateNotNull(): Boolean {
      return properties["byr"] != null &&
        properties["iyr"] != null &&
        properties["eyr"] != null &&
        properties["hgt"] != null &&
        properties["hcl"] != null &&
        properties["ecl"] != null &&
        properties["pid"] != null
    }

    fun validateContents(): Boolean {
      println(properties["hgt"])

      return isNotNullOrEmpty(properties["byr"]) &&
        (1920..2002).contains(properties["byr"]?.toInt()) &&
        isNotNullOrEmpty(properties["iyr"]) &&
        (2010..2020).contains(properties["iyr"]?.toInt()) &&
        isNotNullOrEmpty(properties["eyr"]) &&
        (2020..2030).contains(properties["eyr"]?.toInt()) &&
        isNotNullOrEmpty(properties["hgt"]) &&
        (checkHeight()) &&
        isNotNullOrEmpty(properties["hcl"]) &&
        properties["hcl"]!!.contains(Regex("\\#([0-9]|[a-zA-Z]){6}")) &&
        isNotNullOrEmpty(properties["ecl"]) &&
        properties["ecl"]!!.contains(Regex("amb|blu|brn|gry|grn|hzl|oth")) &&
        isNotNullOrEmpty(properties["pid"]) &&
        properties["pid"]!!.length == 9
    }

    private fun checkHeight(): Boolean {
      if (properties["hgt"]!!.contains("cm"))
        return (150..193).contains(properties["hgt"]!!.substring(0..properties["hgt"]!!.length - 3)?.toInt())
      else if (properties["hgt"]!!.contains("in"))
        return (59..76).contains(properties["hgt"]!!.substring(0..properties["hgt"]!!.length - 3)?.toInt())
      else
        return false
    }

    fun isNotNullOrEmpty(str: String?): Boolean {
      return (str != null && !str.trim().isEmpty())
    }
  }
}

