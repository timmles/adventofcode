package year2020.day6

class Placeholder(val input: List<String>) {
  var customsForms: MutableList<CustomsGroup> = mutableListOf()

  init {
    var tmp = mutableListOf<String>()
    input.forEach {
      if (it.isNotBlank()) {
        tmp.add(it)
      }
      else {
        customsForms.add(CustomsGroup(tmp.toMutableList()))
        tmp.clear()
      }
    }
    // for the last batch before EOF
    customsForms.add(CustomsGroup(tmp.toMutableList()))
    tmp.clear()
  }

  fun doWork(): Int {
    return customsForms.sumBy { it.count() }
  }

  fun doWorkAllPeople(): Int {
    return customsForms.sumBy { it.countAllGroup() }
  }

  fun doWorkAllPeople_wrong(): Int {
    return customsForms.map { it.group }.reduce { acc, customsGroup -> acc.union(customsGroup).toMutableList() }.count()
  }
}

class CustomsGroup(val group: MutableList<String>) {


  fun count(): Int {
    return group.flatMap { it.toList() }.distinct().size
  }

  fun countAllGroup(): Int {
    return group.map { it.toMutableList() }.reduce { acc, s -> acc.intersect(s).toMutableList() }.size
  }
}

