import java.util.Scanner;

public class Assign1 {

    // Maximum size of tree array
    static int n = 10;

    // Array to store tree elements
    static String[] tree = new String[n];


    // -------- CREATE TREE --------
    // User enters elements level by level
    static void createTree(Scanner sc) {
        System.out.print("Enter number of elements: ");
        n = sc.nextInt();
        sc.nextLine(); // clear buffer
        tree = new String[n];



        System.out.println("Enter elements level-wise:");
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextLine();
        }
    }

 // Preorder traversal method
    public static void preorder(String[] tree, int index) {
        if (index >= tree.length || tree[index] == null)
            return;
        System.out.print(tree[index] + " ");
        preorder(tree, 2 * index + 1);
        preorder(tree, 2 * index + 2);
    }

    // Postorder traversal method
    public static void postorder(String[] tree, int index) {
        if (index >= tree.length || tree[index] == null)
            return;
        postorder(tree, 2 * index + 1);
        postorder(tree, 2 * index + 2);
        System.out.print(tree[index] + " ");
    }

    // Inorder traversal method
    public static void Inorder(String[] tree, int index) {
        if (index >= tree.length || tree[index] == null)
            return;
        Inorder(tree, 2 * index + 1);
        System.out.print(tree[index] + " ");
        Inorder(tree, 2 * index + 2);
    }

    // Display array as level order
    static void displayLevelOrder(String[] tree) {
        System.out.print("Level Order: ");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    // Find height of tree
    static int height(String[] tree, int i) {
        if (i >= tree.length || tree[i] == null)
            return 0;

        int leftHeight = height(tree, 2 * i + 1);
        int rightHeight = height(tree, 2 * i + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count total number of nodes
    static int countNodes(String[] tree) {
        int count = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                count++;
        }
        return count;
    }

    // Count number of leaf nodes
    static int countLeafNodes(String[] tree) {
        int count = 0;

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if ((left >= tree.length || tree[left] == null) &&
                    (right >= tree.length || tree[right] == null)) {
                    count++;
                }
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
                    displayLevelOrder(tree);
                    break;

                case 3:
                    System.out.print("Inorder: ");
                    Inorder(tree, 0);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Preorder: ");
                    preorder(tree, 0);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Postorder: ");
                    postorder(tree, 0);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Height of tree: " + height(tree, 0));
                    break;

                case 7:
                    System.out.println("Total nodes: " + countNodes(tree));
                    break;

                case 8:
                    System.out.println("Leaf nodes: " + countLeafNodes(tree));
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
