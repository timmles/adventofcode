package year2018.day8

class DayEight(licenceInput: List<Int>) {

    val tree: LicenceNode

    init {
        this.tree = buildTree(0, licenceInput).first
    }

    fun metaCheck(): Int {
        return tree.metaCount()
    }

    fun nodeValue(): Int {
        return tree.nodeValue()
    }

    private fun buildTree(currentId: Int, licenceInput: List<Int>): Pair<LicenceNode, List<Int>> {
        val node = LicenceNode(currentId, mutableListOf(), mutableListOf())
        val myData = licenceInput.take(2)
        var rest = licenceInput.takeLast(licenceInput.size - 2)

        for (i in 0.until(myData[0])) {
            val buildTree = buildTree(currentId + 1, rest)
            node.children.add(buildTree.first)
            rest = buildTree.second
        }

        node.metadata.addAll(rest.take(myData[1]))
        return Pair(node, rest.takeLast(rest.size - myData[1]))
    }
}

data class LicenceNode(
        val id: Int,
        val children: MutableList<LicenceNode>,
        val metadata: MutableList<Int>
) {
    fun metaCount(): Int {
        return children.sumBy { it.metaCount() } + metadata.sum()
    }

    fun nodeValue(): Int {
        if (children.isEmpty()) {
            return metadata.sum()
        } else {
            return metadata
                    .filter { it != 0 && it < children.size + 1 }
                    .sumBy {
                        children[it-1]?.nodeValue()
                    }
        }
    }

}