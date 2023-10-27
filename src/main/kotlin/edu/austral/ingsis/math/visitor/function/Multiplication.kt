package edu.austral.ingsis.math.visitor.function

import edu.austral.ingsis.math.visitor.visitor.Visitor

class Multiplication(val leftMul: Function, val rightMul: Function): Function {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }
}
