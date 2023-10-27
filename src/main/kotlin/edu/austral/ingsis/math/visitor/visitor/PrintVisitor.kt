package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Number

class PrintVisitor: Visitor<String> {
    override fun visit(variable: Variable): String {
        return variable.variable
    }

    override fun visit(sum: Sum): String {
        return "${sum.leftSum.accept(this)} + ${sum.rightSum.accept(this)}"
    }

    override fun visit(root: Root): String {
        return "√${root.value.accept(this)}"
    }

    override fun visit(substraction: Substraction): String {
        return "${substraction.leftSub.accept(this)} - ${substraction.rightSub.accept(this)}"
    }

    override fun visit(multiplication: Multiplication): String {
        return "${multiplication.leftMul.accept(this)} * ${multiplication.rightMul.accept(this)}"
    }

    override fun visit(division: Division): String {
        return "${division.numerator.accept(this)} / ${division.divisor.accept(this)}"
    }

    override fun visit(number: Number): String {
        return if (number.number % 1 == 0.0) {
            number.number.toInt().toString()
        } else {
            number.toString()
        }
    }

    override fun visit(modulus: Modulus): String {
        return "|${modulus.value.accept(this)}|"
    }

    override fun visit(power: Power): String {
        return "${power.value.accept(this)} ^ ${power.power.accept(this)}"
    }

    override fun visit(parenthesis: Parenthesis): String {
        return "(${parenthesis.function.accept(this)})"
    }
}
