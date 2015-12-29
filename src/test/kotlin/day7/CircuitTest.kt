package day7

import org.junit.Test
import java.util.*

class CircuitTest {
    @Test
    fun testCircuit() {
        val asList = Arrays.asList(
                "123 -> x",
                "456 -> y",
                "x AND y -> d",
                "x OR y -> e",
                "x LSHIFT 2 -> f",
                "y RSHIFT 2 -> g",
                "NOT x -> h",
                "NOT y -> i")

        var circuit = Circuit()

        for (n in asList) {
            circuit.addNode(n)
        }

        circuit.runCircuit()

        println(circuit.known)
    }
}