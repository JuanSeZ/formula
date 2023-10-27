package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.function.*;
import edu.austral.ingsis.math.visitor.function.Number;

import edu.austral.ingsis.math.visitor.visitor.EvalutateVisitor;
import edu.austral.ingsis.math.visitor.visitor.Visitor;
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
        Sum function = new Sum(new Number(1d), new Variable("x"));
        Visitor<Double> visitor = new EvalutateVisitor(variables);
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Map<String,Double> variables = Map.of("div", 4d);
        Division function = new Division(new Number(12d), new Variable("div"));
        Visitor<Double> visitor = new EvalutateVisitor(variables);
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Map<String,Double> variables = Map.of("x", 3d, "y", 4d);
        Multiplication function = new Multiplication(new Division(new Number(9d), new Variable("x")), new Variable("y"));
        Visitor<Double> visitor = new EvalutateVisitor(variables);
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Map<String,Double> variables = Map.of("a", 9d, "b", 3d);
        Power function = new Power(new Division(new Number(27d), new Variable("a")), new Variable("b"));
        Visitor<Double> visitor = new EvalutateVisitor(variables);
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Map<String,Double> variables = Map.of("z", 36d);
        Power function = new Power(new Variable("z"), new Division(new Number(1d), new Number(2d)));
        Visitor<Double> visitor = new EvalutateVisitor(variables);
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Map<String,Double> variables = Map.of("value", 8d);
        Substraction function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        Visitor<Double> visitor = new EvalutateVisitor(variables);
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Map<String,Double> variables = Map.of("value", -8d);
        Substraction function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        Visitor<Double> visitor = new EvalutateVisitor(variables);
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Map<String,Double> variables = Map.of("i", 2d);
        Multiplication function = new Multiplication(new Substraction(new Number(5d), new Variable("i")), new Number(8d));
        Visitor<Double> visitor = new EvalutateVisitor(variables);
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(24d));
    }
}
