package edu.austral.ingsis.math.composite.impl

import edu.austral.ingsis.math.composite.Function
import kotlin.math.sqrt

class Root(private val value: Function): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return sqrt(value.eval(variables))
    }

    override fun print(): String {
        return "√${value.print()}"
    }

    override fun list(): List<String> {
        return value.list()
    }
}
