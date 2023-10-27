package edu.austral.ingsis.math.visitor.function

import edu.austral.ingsis.math.visitor.visitor.Visitor


class Substraction(val leftSub: Function, val rightSub: Function): Function {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }
}
