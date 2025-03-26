import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    Scanner scanner = new Scanner(System.in);

public void insert(int data) {
if (root == null) {
root = new Node(data);
System.out.println("Inserted as root node.");
return;
}

Node current = root;
while (true) {
System.out.print("Enter direction (L/R) from " + current.data + ": ");
String direction = scanner.next();
if (direction.equals("L")) {
if (current.left == null) {
current.left = new Node(data);
System.out.println("Inserted at left of " + current.data);
break;
} else {
current = current.left;
}
} else if (direction.equals("R")) {
if (current.right == null) {
current.right = new Node(data);
System.out.println("Inserted at right of " + current.data);
break;
} else {
current = current.right;
}
} else {
System.out.println("Invalid direction! Enter either 'left' or 'right'.");
}
}
}

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    
    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class BinaryTreeUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for node: ");
            int value = scanner.nextInt();
            tree.insert(value);
        }
        System.out.println("Pre-order Traversal of the Tree:");
        tree.preOrderTraversal(tree.root);
        System.out.println(" ");
        System.out.println("IN-order Traversal of the Tree:");
        tree.inOrderTraversal(tree.root);
        System.out.println(" ");
        System.out.println("Post-order Traversal of the Tree:");
        tree.postOrderTraversal(tree.root);
        scanner.close();
    }
}