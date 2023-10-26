package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.impl.*;
import edu.austral.ingsis.math.composite.impl.Number;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Map<String,Double> variables = Map.of("x", 3d);
        Function function = new Sum(new Number(1d), new Variable("x"));
        final Double result = function.eval(variables);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Map<String,Double> variables = Map.of("div", 4d);
        Function function = new Division(new Number(12d), new Variable("div"));
        final Double result = function.eval(variables);

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Map<String,Double> variables = Map.of("x", 3d, "y", 4d);
        Function function = new Multiplication(new Division(new Number(9d), new Variable("x")), new Variable("y"));
        final Double result = function.eval(variables);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Map<String,Double> variables = Map.of("a", 9d, "b", 3d);
        Function function = new Power(new Division(new Number(27d), new Variable("a")), new Variable("b"));
        final Double result = function.eval(variables);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Map<String,Double> variables = Map.of("z", 36d);
        Function function = new Power(new Variable("z"), new Division(new Number(1d), new Number(2d)));
        final Double result = function.eval(variables);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Map<String,Double> variables = Map.of("value", 8d);
        Function function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        final Double result = 0d;

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Map<String,Double> variables = Map.of("value", -8d);
        Function function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        final Double result = function.eval(variables);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Map<String,Double> variables = Map.of("i", 2d);
        Function function = new Multiplication(new Substraction(new Number(5d), new Variable("i")), new Number(8d));
        final Double result = function.eval(variables);

        assertThat(result, equalTo(24d));
    }
}
