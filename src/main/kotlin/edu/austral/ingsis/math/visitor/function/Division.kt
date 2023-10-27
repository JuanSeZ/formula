package edu.austral.ingsis.math.visitor.function

import edu.austral.ingsis.math.visitor.function.Function
import edu.austral.ingsis.math.visitor.visitor.Visitor

class Division(val numerator: Function, val divisor: Function): Function {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }
}
