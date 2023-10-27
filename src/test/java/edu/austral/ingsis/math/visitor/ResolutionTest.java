package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.function.*;

import edu.austral.ingsis.math.visitor.function.Number;
import edu.austral.ingsis.math.visitor.visitor.EvalutateVisitor;
import edu.austral.ingsis.math.visitor.visitor.Visitor;
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
        Sum function = new Sum(new Number(1d), new Number(6d));
        Visitor<Double> visitor = new EvalutateVisitor(Map.of());
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Division function = new Division(new Number(12d), new Number(2d));
        Visitor<Double> visitor = new EvalutateVisitor(Map.of());
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Multiplication function = new Multiplication(new Division(new Number(9d), new Number(2d)), new Number(3d));
        Visitor<Double> visitor = new EvalutateVisitor(Map.of());
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Power function = new Power(new Division(new Number(27d), new Number(6d)), new Number(2d));
        Visitor<Double> visitor = new EvalutateVisitor(Map.of());
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Power function = new Power(new Number(36d), new Division(new Number(1d), new Number(2d)));
        Visitor<Double> visitor = new EvalutateVisitor(Map.of());
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Modulus function = new Modulus(new Number(136d));
        Visitor<Double> visitor = new EvalutateVisitor(Map.of());
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Modulus function = new Modulus(new Number(-136d));
        Visitor<Double> visitor = new EvalutateVisitor(Map.of());
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Multiplication function = new Multiplication(new Substraction(new Number(5d), new Number(5d)), new Number(8d));
        Visitor<Double> visitor = new EvalutateVisitor(Map.of());
        final Double result = visitor.visit(function);

        assertThat(result, equalTo(0d));
    }
}
