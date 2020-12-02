package year2019.day6

class Node (
  var orbit: Node?,
  val name: String
) {
  var depth = 0
  var children = mutableListOf<Node>()
}

class Universe(input: List<String>) {
  val objects = mutableListOf<Node>()
  val distinctNodes: List<String>

  init {
    distinctNodes = input.map { it.split(')') }.flatten().distinct()
    distinctNodes.forEach { objects.add(Node(null, it)) }

    input.forEach {
      val split = it.split(')')
      val orbit = split[0]
      val name = split[1]

      val parent = objects.find { it.name == orbit }
      val node = objects.find { it.name == name }
      checkNotNull(parent) { "wat" }
      checkNotNull(node) { "wat" }

      node.orbit = parent
      parent.children.add(node)
    }
  }

  private fun buildDepth(node: Node, index: Int) {
    node.depth = index
    node.children.forEach { buildDepth(it, index+1) }
  }

  fun checksum(): Int {
    val node = objects.find { it.name == "COM" }
    checkNotNull(node)

    buildDepth(node, 0)
    return objects.map { it.depth }.sum()
  }

  fun orbitalTransfers(): Int {
    var nodes: MutableMap<String, Int?> = distinctNodes.map { it to null }.toMap().toMutableMap()

    val node = objects.find { it.name == "YOU" }
    checkNotNull(node)
    val parent = node.orbit
    checkNotNull(parent)

    mark(nodes, 0, parent)

    val santa = objects.find { it.name == "SAN" }
    checkNotNull(santa)
    val santaOrbit = santa.orbit
    checkNotNull(santaOrbit)

    return nodes.get(santaOrbit.name)!!
  }

  internal fun mark(nodes: MutableMap<String, Int?>, count: Int, node: Node) {
    if (nodes.get(node.name) != null) {
      return
    }

    nodes.set(node.name, count)

    if (node.orbit != null) {
      mark(nodes, count + 1, node.orbit!!)
    }

    if (node.children.isNotEmpty()) {
      node.children.forEach { mark(nodes, count + 1, it) }
    }
  }
}
