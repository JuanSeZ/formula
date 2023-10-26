package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.impl.*;
import edu.austral.ingsis.math.composite.impl.Number;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function function = new Sum(new Number(1d), new Number(6d));
        final List<String> result = function.list();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function function = new Sum(new Number(12d), new Variable("div"));
        final List<String> result = function.list();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function function = new Multiplication(new Division(new Number(9d), new Variable("x")), new Variable("y"));
        final List<String> result = function.list();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function function = new Power(new Division(new Number(27d), new Variable("a")), new Variable("b"));
        final List<String> result = function.list();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function function = new Power(new Variable("z"), new Number(0.5d));
        final List<String> result = function.list();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        final List<String> result = function.list();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Function function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        final List<String> result = function.list();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function function = new Multiplication(new Substraction(new Number(5d), new Variable("i")), new Number(8d));
        final List<String> result = function.list();

        assertThat(result, containsInAnyOrder("i"));
    }
}
