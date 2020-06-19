package ru.makhmutov.task1;

public enum Machine {
    COCA_COLA("Coca-Cola", 55),
    FANTA("Fanta", 50),
    SPRITE("Sprite", 50),
    PEPSI("Pepsi", 47),
    MIRINDA("Mirinda", 45),
    SEVEN_UP("7 UP", 45);

    private final String name;
    private final int price;

    Machine(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
