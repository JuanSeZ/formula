package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.impl.*;
import edu.austral.ingsis.math.composite.impl.Number;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        Function function = new Sum(new Number(1d), new Number(6d));
        final String expected = "1 + 6";
        final String result = function.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        Function function = new Division(new Number(12d), new Number(2d));
        final String expected = "12 / 2";
        final String result = function.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        Function function = new Multiplication(new Parenthesis(new Division(new Number(9d), new Number(2d))), new Number(3d));
        final String expected = "(9 / 2) * 3";
        final String result = function.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        Function function = new Power(new Parenthesis(new Division(new Number(27d), new Number(6d))), new Number(2d));

        final String expected = "(27 / 6) ^ 2";
        final String result = function.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        Function function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        final String expected = "|value| - 8";
        final String result = function.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        Function function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        final String expected = "|value| - 8";
        final String result = function.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        Function function = new Multiplication(new Parenthesis(new Substraction(new Number(5d), new Variable("i"))), new Number(8d));
        final String expected = "(5 - i) * 8";
        final String result = function.print();

        assertThat(result, equalTo(expected));
    }
}
