package ru.makhmutov.task1;

public enum Operation {
    ADD("Addition"),
    SUBTRACT("Subtraction"),
    MULTIPLY("Multiplication"),
    DIVIDE("Division"),
    TAKE_PERCENTAGE("Taking percentage");

    private final String op;

    /**
     * Constructor for Operation enum
     *
     * @param op Operation name
     */
    Operation(String op) {
        this.op = op;
    }

    /**
     * This is getter method for operation name
     *
     * @return Operation name
     */
    public String getOp() {
        return op;
    }
}
