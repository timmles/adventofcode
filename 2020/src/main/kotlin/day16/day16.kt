package year2020.day16

import common.customSplit

class TicketScanner(val input: List<String>) {

  private val rules: List<Rule>
  private val yourTicket: List<Long>
  private val nearbyTickets: List<List<Int>>

  init {
    val (one, two, three) = input.customSplit("")

    rules = one.map { Rule(it) }
    yourTicket = two[1].split(',').map { it.toLong() }
    nearbyTickets = three.subList(1, three.size).map { it.split(',').map { it.toInt() } }
  }

  fun sumInvalidEntries(): Int {
    return nearbyTickets.sumBy { invalidTicketEntries(it).sum() }
  }

  fun multiplyTicketValues(): Long {
    val validTickets = nearbyTickets.filter { validTicket(it) }

    val pivot: MutableList<List<Int>> = mutableListOf()

    for (i in 0..validTickets[0].lastIndex) {
      pivot.add(validTickets.map { it[i] })
    }

    val map = rules.map { rule ->
      val validColumns = mutableListOf<Int>()
      pivot.forEachIndexed { index, it ->
        val validRule = it.fold(true) { acc, value -> acc && rule.valid(value) }
        if (validRule) validColumns.add(index)
      }
      rule.name to validColumns
    }

    val columnName = pivot.indices.map { it to "" }.toMap().toMutableMap()

    map.sortedBy { it.second.count() }.forEach {
      val intersect: Set<Int> = it.second.intersect(columnName.filter { it.value == "" }.map { it.key })
      columnName[intersect.first()] = it.first
    }


    return columnName
      .filter { it.value.startsWith("departure ") }
      .keys
      .fold(1L) { acc, index -> acc * yourTicket[index] }
  }

  private fun validTicket(ticket: List<Int>): Boolean {
    return invalidTicketEntries(ticket).isEmpty()
  }

  private fun invalidTicketEntries(ticket: List<Int>): List<Int> {
    return ticket.filter { rules.fold(false) { acc, rule -> acc || rule.valid(it) }.not() }
  }
}

class Rule(rule:String) {
  val name: String = rule.split(": ")[0].trim()
  val range1: IntRange
  val range2: IntRange

  init {
    val ranges = rule.split(": ")[1].trim()
    val (range1String, range2String) = ranges.split(" or ")

    val (range1Val1, range1Val2) = range1String.split('-')
    range1 = IntRange(range1Val1.toInt(), range1Val2.toInt())

    val (range2Val1, range2Val2) = range2String.split('-')
    range2 = IntRange(range2Val1.toInt(), range2Val2.toInt())
  }

  fun valid(value: Int): Boolean {
    return range1.contains(value) || range2.contains(value)
  }
}

