package edu.austral.ingsis.math.composite.impl

import edu.austral.ingsis.math.composite.Function
import kotlin.math.absoluteValue

class Modulus(private val value: Function): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return value.eval(variables).absoluteValue
    }

    override fun print(): String {
        return "|${value.print()}|"
    }

    override fun list(): List<String> {
        return value.list()
    }
}
