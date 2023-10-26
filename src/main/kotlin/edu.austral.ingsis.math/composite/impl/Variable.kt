package edu.austral.ingsis.math.composite.impl

import edu.austral.ingsis.math.composite.Function

class Variable(private val variable: String): Function {
    override fun eval(variables: Map<String, Double>): Double {
        return variables[variable] ?: throw RuntimeException("Variable $variable not found")
    }

    override fun print(): String {
        return variable
    }

    override fun list(): List<String> {
        return listOf(variable)
    }

}
