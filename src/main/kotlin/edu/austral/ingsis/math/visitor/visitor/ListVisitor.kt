package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Number

class ListVisitor: Visitor<List<String>> {

    override fun visit(variable: Variable): List<String> {
        return listOf(variable.variable)
    }

    override fun visit(sum: Sum): List<String> {
        return sum.leftSum.accept(this) + sum.rightSum.accept(this)
    }

    override fun visit(root: Root): List<String> {
        return root.value.accept(this)
    }

    override fun visit(substraction: Substraction): List<String> {
        return substraction.leftSub.accept(this) + substraction.rightSub.accept(this)
    }

    override fun visit(multiplication: Multiplication): List<String> {
        return multiplication.leftMul.accept(this) + multiplication.rightMul.accept(this)
    }

    override fun visit(division: Division): List<String> {
        return division.numerator.accept(this) + division.divisor.accept(this)
    }

    override fun visit(number: Number): List<String> {
        return listOf()
    }

    override fun visit(modulus: Modulus): List<String> {
        return modulus.value.accept(this)
    }

    override fun visit(power: Power): List<String> {
        return power.value.accept(this) + power.power.accept(this)
    }

    override fun visit(parenthesis: Parenthesis): List<String> {
        return parenthesis.function.accept(this)
    }
}

