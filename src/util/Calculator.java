package util;

import exception.CalculatorException;

/**
 * @author Fulkin
 * Created on 10.12.2021
 */

public class Calculator {
    private Calculator() {
    }

    public static Numeric calculate(Numeric a, Numeric b, String sign) throws CalculatorException {
        switch (sign) {
            case "+":
                return new Numeric(plus(a.getValue(), b.getValue()), a.getType());
            case "-":
                int first = a.getValue();
                int second = b.getValue();
                if (a.getType() == TypeNumber.ROMAN && first <= second) {
                    throw new CalculatorException("Roman number cannot be less than 1");
                }
                return new Numeric(minus(first, second), a.getType());
            case "*":
                return new Numeric(multiply(a.getValue(), b.getValue()), a.getType());
            case "/":
                return new Numeric(divide(a.getValue(), b.getValue()), a.getType());
            default:
                throw new CalculatorException("Incorrect data entry");
        }
    }

    private static int plus(int a, int b) {
        return a + b;
    }

    private static int minus(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}
