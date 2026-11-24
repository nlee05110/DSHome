package tree;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(12);
		tree.insert(8);
		tree.insert(2);
		tree.insert(17);
		tree.insert(7);
		tree.insert(9);
		tree.insert(11);
		tree.insert(13);
		tree.insert(16);
		tree.insert(18);
		tree.insert(19);
		tree.insert(14);
		tree.insert(1);
		
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.preOrderTraversal(tree.root);
		System.out.println();
		tree.postOrderTraversal(tree.root);
		System.out.println();
        System.out.printf("Leaves: %d\n",tree.getLeaves());
        System.out.printf("Search: %s\n",tree.search(15));
        System.out.printf("Minimum Value: %d\n",tree.findMin());
        int deletedVal = deleteVal(tree);
        System.out.printf("Deleted Value: %d\n", deletedVal);
        tree.delete(deletedVal);
        System.out.printf("Search: %s\n",tree.search(17));
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.postOrderTraversal(tree.root);
		System.out.println();
        deletedVal = deleteVal(tree);
        System.out.printf("Deleted Value: %d\n", deletedVal);
        tree.delete(deletedVal);
        System.out.printf("Leaves: %d\n",tree.getLeaves());
		tree.preOrderTraversal(tree.root);
		System.out.println();
	}

    public static int deleteVal(BinarySearchTree tree){
        Scanner scanner = new Scanner(System.in);    
        System.out.print("Enter value to delete: ");
        int deletedVal = scanner.nextInt();
        while(tree.search(deletedVal)==null){
            
            System.out.print("ERR: Please input specified number that is in tree: ");
            deletedVal = scanner.nextInt(); 
            
        }
        return deletedVal;
        
    }

}
