import java.util.*;

class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    BSTNode root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private BSTNode insertRec(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private BSTNode deleteRec(BSTNode root, int key) {
        if (root == null) return root;
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(BSTNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(BSTNode root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return key < root.data ? searchRec(root.left, key) : searchRec(root.right, key);
    }
}

public class BSTOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            bst.insert(scanner.nextInt());
        }
        
        System.out.println("Inorder Traversal: ");
        bst.inorder();
        
        System.out.print("Enter element to delete: ");
        int delKey = scanner.nextInt();
        bst.delete(delKey);
        System.out.println("Inorder after deletion: ");
        bst.inorder();
        
        System.out.print("Enter element to search: ");
        int searchKey = scanner.nextInt();
        System.out.println(bst.search(searchKey) ? "Element found" : "Element not found");
        
        scanner.close();
    }
}
