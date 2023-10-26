package edu.austral.ingsis.math.composite.impl
import edu.austral.ingsis.math.composite.Function


class Sum(private val leftSum: Function, private val rightSum: Function): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return leftSum.eval(variables) + rightSum.eval(variables)
    }

    override fun print(): String {
        return "${leftSum.print()} + ${rightSum.print()}"
    }

    override fun list(): List<String> {
        return leftSum.list() + rightSum.list()
    }
}
