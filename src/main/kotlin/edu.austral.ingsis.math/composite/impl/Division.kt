package edu.austral.ingsis.math.composite.impl

import edu.austral.ingsis.math.composite.Function

class Division(private val numerator: Function, private val divisor: Function): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return numerator.eval(variables) / divisor.eval(variables)
    }

    override fun print(): String {
        return "${numerator.print()} / ${divisor.print()}"
    }

    override fun list(): List<String> {
        return numerator.list() + divisor.list()
    }
}
