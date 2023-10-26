package edu.austral.ingsis.math.composite.impl
import edu.austral.ingsis.math.composite.Function

class Parenthesis(private val function: Function): Function {
    override fun eval(variables: Map<String, Double>): Double {
        TODO("Not yet implemented")
    }

    override fun print(): String {
        return "(${function.print()})"
    }

    override fun list(): List<String> {
        TODO("Not yet implemented")
    }
}
