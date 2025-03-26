//  Create a Dictionary that stores keywords and its meanings, using appropriate data structure.
// Implement its operations such as add, delete, display, search and update its values.
import java.util.Scanner;

class Node {
    String key;
    String value;
    Node left, right;

    public Node(String item) {
        key = item;
        value = item;
        left = right = null;
    }
}



class Dictionary {
    Node root;

    Dictionary() {
        root = null;
    }

    void add(String key, String value) {
        root = addRec(root, key, value);
    }

    Node addRec(Node root, String key, String value) {
        if (root == null) {
            root = new Node(key);
            root.value = value;
            return root;
        }
        if (key.compareTo(root.key) < 0)
            root.left = addRec(root.left, key, value);
        else if (key.compareTo(root.key) > 0)
            root.right = addRec(root.right, key, value);
        return root;
    }

    void delete(String key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, String key) {
        if (root == null) return root;

        if (key.compareTo(root.key) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    String minValue(Node root) {
        String minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void update(String key, String newValue) {
        Node node = searchRec(root, key);
        if (node != null) {
            node.value = newValue;
        }
    }

    Node searchRec(Node root, String key) {
        if (root == null || root.key.equals(key))
            return root;
        if (root.key.compareTo(key) > 0)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    void display() {
        displayRec(root);
    }

    void displayRec(Node root) {
        if (root != null) {
            displayRec(root.left);
            System.out.println(root.key + ": " + root.value);
            displayRec(root.right);
        }
    }

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add\n2. Delete\n3. Display\n4. Search\n5. Update\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("Enter key:");
                    String key = scanner.nextLine();
                    System.out.println("Enter value:");
                    String value = scanner.nextLine();
                    dict.add(key, value);
                    break;
                case 2:
                    System.out.println("Enter key to delete:");
                    key = scanner.nextLine();
                    dict.delete(key);
                    break;
                case 3:
                    dict.display();
                    break;
                case 4:
                    System.out.println("Enter key to search:");
                    key = scanner.nextLine();
                    Node result = dict.searchRec(dict.root, key);
                    if (result != null) {
                        System.out.println("Found: " + result.key + " -> " + result.value);
                    } else {
                        System.out.println("Key not found");
                    }
                    break;
                case 5:
                    System.out.println("Enter key to update:");
                    key = scanner.nextLine();
                    System.out.println("Enter new value:");
                    value = scanner.nextLine();
                    dict.update(key, value);
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }
}