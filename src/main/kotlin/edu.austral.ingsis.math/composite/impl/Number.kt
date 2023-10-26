package edu.austral.ingsis.math.composite.impl

import edu.austral.ingsis.math.composite.Function

class Number(private val number: Double): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return number
    }

    override fun print(): String {
        return if (number % 1 == 0.0) {
            number.toInt().toString()
        } else {
            number.toString()
        }
    }

    override fun list(): List<String> {
        return listOf()
    }
}
