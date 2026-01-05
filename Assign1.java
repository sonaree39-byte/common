import java.util.Scanner;

public class Assign1 {

    // Maximum size of tree array
    static int MAX = 50;

    // Array to store tree elements
    static int[] tree = new int[MAX];

    // Number of nodes actually present
    static int n = 0;

    // -------- CREATE TREE --------
    // User enters elements level by level
    static void createTree(Scanner sc) {
        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();

        System.out.println("Enter elements level-wise:");
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }
    }

    // -------- DISPLAY LEVEL ORDER --------
    // Simply prints array elements
    static void displayLevelOrder() {
        System.out.print("Level Order: ");
        for (int i = 0; i < n; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    // -------- INORDER TRAVERSAL --------
    // Left → Root → Right
    static void inorder(int i) {
        if (i >= n) return;

        inorder(2 * i + 1);       // left child
        System.out.print(tree[i] + " ");
        inorder(2 * i + 2);       // right child
    }

    // -------- PREORDER TRAVERSAL --------
    // Root → Left → Right
    static void preorder(int i) {
        if (i >= n) return;

        System.out.print(tree[i] + " ");
        preorder(2 * i + 1);
        preorder(2 * i + 2);
    }

    // -------- POSTORDER TRAVERSAL --------
    // Left → Right → Root
    static void postorder(int i) {
        if (i >= n) return;

        postorder(2 * i + 1);
        postorder(2 * i + 2);
        System.out.print(tree[i] + " ");
    }

    // -------- HEIGHT OF TREE --------
    // Height = max height of left & right + 1
    static int height(int i) {
        if (i >= n) return 0;

        int leftHeight = height(2 * i + 1);
        int rightHeight = height(2 * i + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // -------- COUNT TOTAL NODES --------
    static int countNodes() {
        return n;   // number of elements in array = number of nodes
    }

    // -------- COUNT LEAF NODES --------
    // Leaf node = node with no children
    static int countLeafNodes() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left >= n && right >= n) {
                count++;
            }
        }
        return count;
    }

    // -------- MAIN MENU --------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- TREE MENU ----");
            System.out.println("1. Create Tree");
            System.out.println("2. Display Level Order");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Postorder Traversal");
            System.out.println("6. Find Height of Tree");
            System.out.println("7. Count Total Nodes");
            System.out.println("8. Count Leaf Nodes");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createTree(sc);
                    break;

                case 2:
                    displayLevelOrder();
                    break;

                case 3:
                    System.out.print("Inorder: ");
                    inorder(0);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Preorder: ");
                    preorder(0);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Postorder: ");
                    postorder(0);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Height of tree: " + height(0));
                    break;

                case 7:
                    System.out.println("Total nodes: " + countNodes());
                    break;

                case 8:
                    System.out.println("Leaf nodes: " + countLeafNodes());
                    break;

                case 9:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);

        sc.close();
    }
}
