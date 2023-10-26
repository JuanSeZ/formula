package edu.austral.ingsis.math.composite.impl

import edu.austral.ingsis.math.composite.Function

class Substraction(private val leftSub: Function, private val rightSub: Function): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return leftSub.eval(variables) - rightSub.eval(variables)
    }

    override fun print(): String {
        return "${leftSub.print()} - ${rightSub.print()}"
    }

    override fun list(): List<String> {
        return leftSub.list() + rightSub.list()
    }
}
