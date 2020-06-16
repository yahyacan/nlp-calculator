package com.nlp.enums;

import java.util.Arrays;
import java.util.List;

/**
 * @author yahya
 */
public enum ArithmeticOperators {

    ADD(Arrays.asList("ADD", "PLUS")),
    SUBTRACT(Arrays.asList("SUBTRACT", "MINUS", "LESS")),
    MULTIPLY(Arrays.asList("MULTIPLIED-BY", "TIMES")),
    DIVIDE(Arrays.asList("DIVIDED-BY", "OVER"));

    private List<String> labels;

    ArithmeticOperators(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getLabels() {
        return labels;
    }

    public static ArithmeticOperators findByName(String name) {
        for (ArithmeticOperators operators : ArithmeticOperators.values()) {
            if (operators.getLabels().contains(name))
                return operators;
        }
        return null;
    }
}
