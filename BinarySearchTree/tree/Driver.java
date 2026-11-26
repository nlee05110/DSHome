package tree;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
        System.out.println("-----------New Tree Instantiated------------");
        buildTree(tree);
        runProgram(tree);
	}

    public static void buildTree(BinarySearchTree tree) {
        boolean exitProgram = false;
        Scanner scanner = new Scanner(System.in);
        int input;
        System.out.print("Enter value for root node:");
        input = scanner.nextInt();
        tree.insert(input);
        while(exitProgram==false){
            System.out.print("Enter unique value for child node or [-1 to exit]:");
            input = scanner.nextInt();
            if(input==-1){
                exitProgram = true;
            } else if(input>-1){
                tree.insert(input);
            }
        }
        
    }

    public static void runProgram(BinarySearchTree tree) {
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;
        int input;
        System.out.println("\n\n<<<-----Enter value for desired function----->>>");
        System.out.println("|                                             |");
        System.out.println("v                                             v");
        System.out.println("|                                             |");
        showTree(tree);
        displayOptions();
        while(exitProgram==false){
            System.out.print("Input options 1-6 from the menu: ");
            input = scanner.nextInt();

            switch(input){
                case 1: searchNode(tree); break;
                case 2: isEmpty(tree); break;
                case 3: getLeaves(tree); break;
                case 4: getMinVal(tree); break;
                case 5: displayAllTraversalOrders(tree); break;
                case 6: deleteVal(tree); break;
                case -1: exitProgram=true;
            }
            System.out.println();
        }
    }

    public static void deleteVal(BinarySearchTree tree){
        Scanner scanner = new Scanner(System.in);    
        System.out.print("Enter value to delete: ");
        int deletedVal = scanner.nextInt();
        while(tree.search(deletedVal)==null){
            System.out.print("ERR: Please input specified number that is in tree: ");
            deletedVal = scanner.nextInt(); 
        }
        tree.delete(deletedVal);
    }

    public static void searchNode(BinarySearchTree tree){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the value of node to find:");
        int searchVal = scanner.nextInt();
        Node searchNode = tree.search(searchVal);
        displayNodeContents(tree, searchNode);
    }

    public static void displayNodeContents(BinarySearchTree tree, Node root){
        if(root!=null) {
            if(tree.hasRightChild(root)&&tree.hasLeftChild(root)){
			    System.out.printf("VAL: %d LEFT: %d RIGHT: %d\n", root.key, root.left.key, root.right.key);
            }else if(tree.hasRightChild(root)){
			    System.out.printf("VAL: %d LEFT: NULL RIGHT: %d\n", root.key, root.right.key);
            }else if(tree.hasLeftChild(root)){
			    System.out.printf("VAL: %d LEFT: %d RIGHT: NULL\n", root.key, root.left.key);
            } else {
			    System.out.printf("VAL: %d LEFT: NULL RIGHT: NULL\n", root.key);
            }
        } else {
            System.out.println("ERR: Node does not exist");
        }
			
    }

    public static void getLeaves(BinarySearchTree tree){
        System.out.printf("# of Leaves: %d\n", tree.getLeaves());
    }

    public static void isEmpty(BinarySearchTree tree){
       if(tree.isEmpty() == true){
            System.out.println("Tree is NOT empty"); 
            return;
        }
        System.out.println("Tree is Empty, add a new node or end program");
    }

    public static void getMinVal(BinarySearchTree tree) {
        System.out.printf("Minimum Value: %d\n",tree.findMin());
    }
    public static void displayOptions(){
        System.out.println("To search address of value---------[1]:");
        System.out.println("To check if tree is empty----------[2]:");
        System.out.println("To get # of leaves in tree---------[3]:");
        System.out.println("To check minimum value in tree-----[4]:");
        System.out.println("To Display all traversal orders----[5]:");
        System.out.println("To delete a node-------------------[6]:");
        System.out.println("Show Menu-------------------[6]:");
        
    }

    public static void displayAllTraversalOrders(BinarySearchTree tree) {
        inOrderTraversal(tree);
        preOrderTraversal(tree);
        postOrderTraversal(tree);
    }

    public static void showTree(BinarySearchTree tree){
        System.out.println("-------------BINARY SEARCH TREE----------------");
        tree.postOrderTraversal(tree.root);
        System.out.println();
    }

    public static void inOrderTraversal(BinarySearchTree tree){
        System.out.println("----------In Order Traversal (LEFT-->ROOT-->RIGHT)------------");
		tree.inOrderTraversal(tree.root);
		System.out.println();
    }

    public static void preOrderTraversal(BinarySearchTree tree){
        System.out.println("----------Pre Order Traversal (ROOT-->LEFT-->RIGHT)-----------");
		tree.preOrderTraversal(tree.root);
		System.out.println();
    }
    
    public static void postOrderTraversal(BinarySearchTree tree){
        System.out.println("----------Post Order Traversal (LEFT-->RIGHT-->ROOT)----------");
		tree.postOrderTraversal(tree.root);
		System.out.println();
    }
}
