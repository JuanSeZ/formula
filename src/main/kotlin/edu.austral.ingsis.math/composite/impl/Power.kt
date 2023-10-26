package edu.austral.ingsis.math.composite.impl

import edu.austral.ingsis.math.composite.Function
import kotlin.math.pow

class Power(private val value: Function, private val power: Function): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return value.eval(variables).pow(power.eval(variables))
    }

    override fun print(): String {
        return "${value.print()} ^ ${power.print()}"
    }

    override fun list(): List<String> {
        return value.list() + power.list()
    }
}
