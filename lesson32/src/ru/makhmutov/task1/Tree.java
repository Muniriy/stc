package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {
    private static final Logger log = LogManager.getLogger(Tree.class);
    private final List<T> listForPrint = new ArrayList<>();
    private T val;
    private Tree<T> left;
    private Tree<T> right;
    private Tree<T> parent;

    /**
     * The constructor for Tree class
     *
     * @param val    The value of a node
     * @param parent The parent of a node
     */
    public Tree(T val, Tree<T> parent) {
        this.val = val;
        this.parent = parent;
    }

    public T val() {
        return val;
    }

    /**
     * This is a getter for the left node
     *
     * @return Pointer to the left node
     */
    public Tree<T> left() {
        return left;
    }

    /**
     * This is a getter for the right node
     *
     * @return Pointer to the right node
     */
    public Tree<T> right() {
        return right;
    }

    /**
     * This is a getter for the parent node
     *
     * @return Pointer to the parent node
     */
    public Tree<T> parent() {
        return parent;
    }

    /**
     * This method allows to add new nodes to the tree
     *
     * @param vals The values of new nodes
     */
    @SafeVarargs
    public final void add(T... vals) {
        for (T v : vals) {
            add(v);
        }
    }

    /**
     * This method allows to add new node to the tree
     *
     * @param val The value of a new node
     */
    public void add(T val) {
        if (val.compareTo(this.val) < 0) {
            if (this.left == null) {
                this.left = new Tree<>(val, this);
            } else {
                this.left.add(val);
            }
        } else {
            if (this.right == null) {
                this.right = new Tree<>(val, this);
            } else {
                this.right.add(val);
            }
        }
    }

    /**
     * This recursive method allows to search for the value in the tree
     *
     * @param tree The tree
     * @param val  The value to be searched
     * @return The node containing the value
     */
    private Tree<T> recursiveSearch(Tree<T> tree, T val) {
        if (tree == null) {
            return null;
        }
        switch (val.compareTo(tree.val)) {
            case 1:
                return recursiveSearch(tree.right, val);
            case -1:
                return recursiveSearch(tree.left, val);
            case 0:
                return tree;
            default:
                return null;
        }
    }

    /**
     * This method allows to search for value in the tree
     *
     * @param val The value to be searched
     * @return The node containing the value
     */
    public Tree<T> search(T val) {
        return recursiveSearch(this, val);
    }

    /**
     * This method allows to remove nodes from the tree
     *
     * @param val The value to be removed
     * @return true - if node was removed, otherwise - false
     */
    public boolean remove(T val) {
        // Check if the node exists
        Tree<T> tree = search(val);
        if (tree == null) {
            // If node does not exist, return false
            return false;
        }
        Tree<T> curTree;

        // If root is deleted
        if (tree == this) {
            if (tree.right != null) {
                curTree = tree.right;
            } else curTree = tree.left;
            while (curTree.left != null) {
                curTree = curTree.left;
            }
            T temp = curTree.val;
            this.remove(temp);
            tree.val = temp;
            return true;
        }

        // If leaf is deleted
        if (tree.left == null && tree.right == null && tree.parent != null) {
            if (tree == tree.parent.left) {
                tree.parent.left = null;
            } else {
                tree.parent.right = null;
            }
            return true;
        }

        // Deletion of a node with the left subtree and without right subtree
        if (tree.left != null && tree.right == null) {
            // Change the parent
            tree.left.parent = tree.parent;
            if (tree == tree.parent.left) {
                tree.parent.left = tree.left;
            } else if (tree == tree.parent.right) {
                tree.parent.right = tree.left;
            }
            return true;
        }

        // Deletion of a node with the right subtree and without left subtree
        if (tree.left == null && tree.right != null) {
            // Change the parent
            tree.right.parent = tree.parent;
            if (tree == tree.parent.left) {
                tree.parent.left = tree.right;
            } else if (tree == tree.parent.right) {
                tree.parent.right = tree.right;
            }
            return true;
        }

        // Deletion of a node with both subtrees
        if (tree.right != null && tree.left != null) {
            curTree = tree.right;
            while (curTree.left != null) {
                curTree = curTree.left;
            }

            // If the most left element is the first offspring
            if (curTree.parent == tree) {
                curTree.left = tree.left;
                tree.left.parent = curTree;
                curTree.parent = tree.parent;
                if (tree == tree.parent.left) {
                    tree.parent.left = curTree;
                } else if (tree == tree.parent.right) {
                    tree.parent.right = curTree;
                }
                return true;
            } else { // If the most left element is not the first offspring
                if (curTree.right != null) {
                    curTree.right.parent = curTree.parent;
                }
                curTree.parent.left = curTree.right;
                curTree.right = tree.right;
                curTree.left = tree.left;
                tree.left.parent = curTree;
                tree.right.parent = curTree;
                curTree.parent = tree.parent;
                if (tree == tree.parent.left) {
                    tree.parent.left = curTree;
                } else if (tree == tree.parent.right) {
                    tree.parent.right = curTree;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * This recursive method allows to print the value of all nodes
     * and append their values to the string
     *
     * @param node The current node
     * @param sb   The string containing values of all elements
     */
    private void recursivePrinter(Tree<T> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        recursivePrinter(node.left, sb);
        listForPrint.add(node.val);
        sb.append(node);
        sb.append(" ");
        if (node.right != null) {
            recursivePrinter(node.right, sb);
        }
    }

    /**
     * This method allows to print the values of all nodes
     */
    public void print() {
        listForPrint.clear();
        StringBuilder sb = new StringBuilder();
        recursivePrinter(this, sb);
        log.info("The content of the tree: {}", sb);
    }

    @Override
    public String toString() {
        return val.toString();
    }

    /**
     * This recursive method allows to find all leaves
     * of the tree and append their values to the string
     *
     * @param node The current node
     * @param sb   The string containing all tree leaves
     */
    private void recursiveLeafFinder(Tree<T> node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            sb.append(node.val).append(" ");
            return;
        }
        if (node.left != null) {
            recursiveLeafFinder(node.left, sb);
        }
        if (node.right != null) {
            recursiveLeafFinder(node.right, sb);
        }
    }

    /**
     * This method allows to find leaves of the tree
     * and then prints them
     */
    public void findLeaves() {
        StringBuilder sb = new StringBuilder();
        recursiveLeafFinder(this, sb);
        log.info("Leaves of the tree: {}", sb);
    }
}
