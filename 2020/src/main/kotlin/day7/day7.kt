package year2020.day7

class LuggageProcessor(val input: List<String>) {
  private val bagRules = mutableMapOf<String, List<Pair<Int, String>>>()

  init {
    input.forEach { inputLine ->
      val (parent, childrenString) =
        inputLine.split("contain").map {
          it
            .replace("bags", "")
            .replace("bag", "")
            .trim('.')
            .trim()
        }

      val childrenStringList = childrenString.split(',').map { it.trim() }
      val children = childrenStringList.map {
        if (it == "no other")
          Pair(0, "blank")
        else
          Pair(it[0].toString().toInt(), it.substring(1).trim())
      }

      bagRules[parent] = children
    }
  }

  fun possibleContainers(targetBag: String): Int {
    return search(targetBag).distinct().size
  }

  private fun search(targetBag: String): List<String> {
    val targetParent = bagRules.filter { it.value.map { it.second }.contains(targetBag) }
    val parents = mutableListOf<String>()

    targetParent.forEach { parents.add(it.key); parents.addAll(search(it.key)) }

    return parents
  }

  fun requiredBagsFromTarget(targetBag: String): Int {
    // required bags includes the current bag, so minus one to excluded counting the root/target bag
    return requiredBags(targetBag) - 1
  }

  fun requiredBags(targetBag: String): Int {
    val list = bagRules[targetBag]
    if (list != null) {
      return list.fold(1) { acc, pair -> acc + pair.first * requiredBags(pair.second) }
    } else
      return 0
  }
}

