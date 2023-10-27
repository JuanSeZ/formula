package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Number

interface Visitor<T> {
    fun visit(variable: Variable): T
    fun visit(sum: Sum): T
    fun visit(root: Root): T
    fun visit(substraction: Substraction): T
    fun visit(multiplication: Multiplication): T
    fun visit(division: Division): T
    fun visit(number: Number): T
    fun visit(modulus: Modulus): T
    fun visit(power: Power): T
    fun visit(parenthesis: Parenthesis): T

}
