package ru.makhmutov.task1;

public class LeafCounter {
    /**
     * The entry point of UnrepeatedSymbol program.
     * This program allows to count leaves of binary tree
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(33, null);
        tree.add(5, 35, 1, 20, 99, 17, 18, 19, 31, 4);
        tree.print();
        tree.findLeaves();

        tree.remove(99);
        tree.print();
        tree.findLeaves();

        tree.remove(20);
        tree.print();
        tree.findLeaves();

        tree.remove(33);
        tree.print();
        tree.findLeaves();
    }
}
