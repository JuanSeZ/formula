package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Number
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class EvalutateVisitor(private val variables: Map<String,Double>) : Visitor<Double> {

    override fun visit(variable: Variable): Double {
        return variables[variable.variable] ?: throw Exception("Variable ${variable.variable} not found")
    }

    override fun visit(sum: Sum): Double {
        return sum.leftSum.accept(this) + sum.rightSum.accept(this)
    }

    override fun visit(root: Root): Double {
        return sqrt(root.value.accept(this))
    }

    override fun visit(substraction: Substraction): Double {
        return substraction.leftSub.accept(this) - substraction.rightSub.accept(this)
    }

    override fun visit(multiplication: Multiplication): Double {
        return multiplication.leftMul.accept(this) * multiplication.rightMul.accept(this)
    }

    override fun visit(division: Division): Double {
        return division.numerator.accept(this) / division.divisor.accept(this)
    }

    override fun visit(number: Number): Double {
        return number.number
    }

    override fun visit(modulus: Modulus): Double {
        return abs(modulus.value.accept(this))
    }

    override fun visit(power: Power): Double {
        return power.value.accept(this).pow(power.power.accept(this))
    }

    override fun visit(parenthesis: Parenthesis): Double {
        return parenthesis.function.accept(this)
    }

}
