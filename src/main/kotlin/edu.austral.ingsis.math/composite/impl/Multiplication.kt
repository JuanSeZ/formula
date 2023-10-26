package edu.austral.ingsis.math.composite.impl
import edu.austral.ingsis.math.composite.Function

class Multiplication(private val leftMul: Function, private val rightMul: Function): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return leftMul.eval(variables) * rightMul.eval(variables)
    }

    override fun print(): String {
        return "${leftMul.print()} * ${rightMul.print()}"
    }

    override fun list(): List<String> {
        return leftMul.list() + rightMul.list()
    }
}
