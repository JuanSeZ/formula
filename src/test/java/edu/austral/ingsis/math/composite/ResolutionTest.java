package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.impl.*;
import edu.austral.ingsis.math.composite.impl.Number;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function function = new Sum(new Number(1d), new Number(6d));
        final Double result = function.eval(Map.of());

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Function function = new Division(new Number(12d), new Number(2d));
        final Double result = function.eval(Map.of());

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Function function = new Multiplication(new Division(new Number(9d), new Number(2d)), new Number(3d));
        final Double result = function.eval(Map.of());

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Function function = new Power(new Division(new Number(27d), new Number(6d)), new Number(2d));
        final Double result = function.eval(Map.of());

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function function = new Power(new Number(36d), new Division(new Number(1d), new Number(2d)));
        final Double result = function.eval(Map.of());

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function function = new Modulus(new Number(136d));
        final Double result = function.eval(Map.of());

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function function = new Modulus(new Number(-136d));
        final Double result = function.eval(Map.of());

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function function = new Multiplication(new Substraction(new Number(5d), new Number(5d)), new Number(8d));
        final Double result = function.eval(Map.of());

        assertThat(result, equalTo(0d));
    }
}
