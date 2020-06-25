package ru.makhmutov.task1;

public enum Operation {
    ADD("Addition"),
    SUBTRACT("Subtraction"),
    MULTIPLY("Multiplication"),
    DIVIDE("Division"),
    TAKE_PERCENTAGE("Taking percentage");

    private final String op;

    Operation(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }
}
