package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.function.*;
import edu.austral.ingsis.math.visitor.function.Number;
import edu.austral.ingsis.math.visitor.visitor.PrintVisitor;
import edu.austral.ingsis.math.visitor.visitor.Visitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        Sum function = new Sum(new Number(1d), new Number(6d));
        final String expected = "1 + 6";
        Visitor<String> visitor = new PrintVisitor();
        final String result = visitor.visit(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        Division function = new Division(new Number(12d), new Number(2d));
        final String expected = "12 / 2";
        Visitor<String> visitor = new PrintVisitor();
        final String result = visitor.visit(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        Multiplication function = new Multiplication(new Parenthesis(new Division(new Number(9d), new Number(2d))), new Number(3d));
        final String expected = "(9 / 2) * 3";
        Visitor<String> visitor = new PrintVisitor();
        final String result = visitor.visit(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        Power function = new Power(new Parenthesis(new Division(new Number(27d), new Number(6d))), new Number(2d));

        final String expected = "(27 / 6) ^ 2";
        Visitor<String> visitor = new PrintVisitor();
        final String result = visitor.visit(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        Substraction function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        final String expected = "|value| - 8";
        Visitor<String> visitor = new PrintVisitor();
        final String result = visitor.visit(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        Substraction function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        final String expected = "|value| - 8";
        Visitor<String> visitor = new PrintVisitor();
        final String result = visitor.visit(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        Multiplication function = new Multiplication(new Parenthesis(new Substraction(new Number(5d), new Variable("i"))), new Number(8d));
        final String expected = "(5 - i) * 8";
        Visitor<String> visitor = new PrintVisitor();
        final String result = visitor.visit(function);

        assertThat(result, equalTo(expected));
    }
}
