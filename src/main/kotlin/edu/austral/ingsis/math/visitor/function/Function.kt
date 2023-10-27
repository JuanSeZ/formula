package edu.austral.ingsis.math.visitor.function

import edu.austral.ingsis.math.visitor.visitor.Visitor

interface Function {
    fun <T> accept(visitor: Visitor<T>) :T
}
