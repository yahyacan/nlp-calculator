package com.nlp.enums;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

/**
 * @author yahya
 */
public enum ArithmeticOperators {

    ADD(Arrays.asList("ADD", "PLUS"), (val1,val2) -> val1 + val2),
    SUBTRACT(Arrays.asList("SUBTRACT", "MINUS", "LESS"), (val1,val2) -> val1 - val2),
    MULTIPLY(Arrays.asList("MULTIPLIED-BY", "TIMES"), (val1,val2) -> val1 * val2),
    DIVIDE(Arrays.asList("DIVIDED-BY", "OVER"), (val1,val2) -> val1 / val2);

    private List<String> labels;
    private DoubleBinaryOperator operator;

    ArithmeticOperators(List<String> labels,DoubleBinaryOperator operator) {
        this.labels = labels;
        this.operator = operator;
    }

    public List<String> getLabels() {
        return labels;
    }

    public double getResult(double val1, double val2){
        return operator.applyAsDouble(val1,val2);
    }

}
