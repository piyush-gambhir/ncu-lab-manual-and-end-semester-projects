/*
Problem Statement

Write a program to implement Following operations using Binary Search Tree:
1.Insertion
2.Deletion
3.Traversal [PREORDER, POSTORDER, INORDER]
*/

class BinarySearchTree {

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        this.root = null;
    }

    BinarySearchTree(int r) {
        this.root = new Node(r);
    }

    Node insertNode(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertNode(root.left, key);
        else if (key > root.key)
            root.right = insertNode(root.right, key);

        return root;
    }

    Node deleteNode(Node root, int key) {

        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

        else {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteNode(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }
}

/**
 * problem_statement_experiment_15
 */
public class problem_statement_experiment_15 {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(65);
        tree.insertNode(tree.root, 30);
        tree.insertNode(tree.root, 20);
        tree.insertNode(tree.root, 40);
        tree.insertNode(tree.root, 70);
        tree.insertNode(tree.root, 60);
        tree.insertNode(tree.root, 80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("Preorder traversal of the given tree");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("Postorder traversal of the given tree");
        tree.postorder(tree.root);
        System.out.println("\n");
        System.out.println("Delete 20");
        tree.deleteNode(tree.root, 20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder(tree.root);
        System.out.println("\n");
        System.out.println("Delete 30");
        tree.deleteNode(tree.root, 30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder(tree.root);
    }
}