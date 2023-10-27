package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.function.*;
import edu.austral.ingsis.math.visitor.function.Number;

import edu.austral.ingsis.math.visitor.visitor.ListVisitor;
import edu.austral.ingsis.math.visitor.visitor.Visitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Sum function = new Sum(new Number(1d), new Number(6d));
        ListVisitor visitor = new ListVisitor();
        final List<String> result = visitor.visit(function);



        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Sum function = new Sum(new Number(12d), new Variable("div"));
        ListVisitor visitor = new ListVisitor();
        final List<String> result = visitor.visit(function);

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Multiplication function = new Multiplication(new Division(new Number(9d), new Variable("x")), new Variable("y"));
        ListVisitor visitor = new ListVisitor();
        final List<String> result = visitor.visit(function);

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Power function = new Power(new Division(new Number(27d), new Variable("a")), new Variable("b"));
        ListVisitor visitor = new ListVisitor();
        final List<String> result = visitor.visit(function);

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Power function = new Power(new Variable("z"), new Number(0.5d));
        ListVisitor visitor = new ListVisitor();
        final List<String> result = visitor.visit(function);

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Substraction function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        ListVisitor visitor = new ListVisitor();
        final List<String> result = visitor.visit(function);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Substraction function = new Substraction(new Modulus(new Variable("value")), new Number(8d));
        ListVisitor visitor = new ListVisitor();
        final List<String> result = visitor.visit(function);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Multiplication function = new Multiplication(new Substraction(new Number(5d), new Variable("i")), new Number(8d));
        ListVisitor visitor = new ListVisitor();
        final List<String> result = visitor.visit(function);

        assertThat(result, containsInAnyOrder("i"));
    }
}
