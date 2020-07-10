package ru.makhmutov.task1;

public class Child {

    /**
     * This method allows child to eat the food.
     * In case of preferable food,
     *
     * @param food The food served by mother
     * @throws UneatenFoodException An exception in case of child
     *                              refusing to eat the food
     */
    public void eat(Food food) throws UneatenFoodException {
        String like = "\tСъел " + food.getName().toLowerCase() + " за обе щеки";
        String dislike = food.getName() + " не нравится ребёнку";
        System.out.println("Ребёнок: ");
        try {
            switch (food) {
                case APPLE:
                    System.out.println(like);
                    break;
                case CARROT:
                case PORRIDGE:
                    throw new UneatenFoodException(dislike);
                case CAESAR_SALAD:
                    System.out.println(like);
                    break;
                case MUSHROOM_SOUP:
                    System.out.println(like);
                    break;
                default:
                    System.out.println("Несуществующая еда");
            }
        } finally {
            System.out.println("\tСпасибо, мама!");
        }
    }
}
