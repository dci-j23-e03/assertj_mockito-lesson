package org.example;

public class MathOperations {

    private Calculator calc;

    public MathOperations(Calculator calc) {
        this.calc = calc;
    }

    public int multiply(int a, int b) {
        int result = calc.multiply(a, b);
        System.out.println("Multiplication: " + print(a, b, result));
        return result;
    }

    public int add(int a, int b) {
        int result = calc.add(a, b);
        System.out.println("Addition: " + print(a, b, result));
        return result;
    }

    private String print(int a, int b, int result) {
        return String.format("Arguments: %d, %d Result: %d", a, b, result);
    }

    public int addThenMultiply(int a, int b) {
        int result = calc.add(a, b);
        result += calc.multiply(a, b);
        return result;
    }
}
