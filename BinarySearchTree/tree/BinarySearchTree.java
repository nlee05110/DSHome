package tree;

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		this.root=null;
	}
	
	//****** INSERT ***************************
	public void insert(int key) {
		this.root = insert(root,key);
	}

	private Node insert(Node current, int key) {
		if(current==null) {
			current = new Node(key);
			return current;
		}
		if(key<current.key) {
			current.left = insert(current.left,key);
		}else {
			if(key > current.key) {
				current.right = insert(current.right,key);	
			}
		}
		return current;
	}
	
	//****** SEARCH ***************************
	public Node search(int value) {
		Node node = search(this.root,value);
		return node;
	}
	
	private Node search(Node current, int value){
        if(value==current.key) {
            System.out.printf("Value Found: %s\n", current.key);
            return current;
        } else if(value<current.key){ 
            return search(current.left, value);
        } else if(value>current.key ){
            return search(current.right, value);
        }
		return null;
	}
	
	//****** DELETE ***************************
	public void delete(int key) {
		delete(this.root,key); //Deleted this.root = 
	}
	
	private Node delete(Node current, int value){
        if(current.right.key == value){
            if(hasChildren(current.right)){
                if(hasLeftChild(current.right)){
                    Node temp = current.right.left;    
                    current.right = current.right.right;
                    current.right.left = temp;
                } else {
                    current.right = current.right.right;
                }
            } else {
                current.right = null;
            }
            return current;
       } 
        if(current.left.key == value){
            if(hasChildren(current.left)){
                if(hasRightChild(current.left)){
                    Node temp = current.left.right;    
                    current.left = current.left.left;
                    current.left.right = temp;
                } else {
                    current.left = current.left.left;
                }
            } else {
                current.left = null;
            }
                
            return current;
        } else if(value<current.key){
            return delete(current.left, value);
        } else if(value>current.key){
            return delete(current.right,value);
        }
		return null;
	}
	
	
	//****** Find Minimum Key Value ***************************
	public int findMin(Node node) {
		return 0;
	}
	
	//****** Height (Count in Nodes) ***************************
	public int height(Node root) {
    	return 0;
    }
    
    //****** Count Leaves ***************************
	public int countLeaves(Node root) {
		return 0;
	}
	
	//****** isValidBST ***************************
	public boolean isValidBST(Node root) {
		return false;
	}
	
	
	public void inOrderTraversal(Node root) {
		// Left-Root-Right
		if(root!=null) {
			inOrderTraversal(root.left);
			System.out.printf(" %d ", root.key);
			inOrderTraversal(root.right);
		}
	}
	
	public void preOrderTraversal(Node root) {
		// Root-Left-Right
		if(root!=null) {
			System.out.printf(" %d ", root.key);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

    public boolean hasChildren(Node current){
        if(current.right!=null||current.left!=null){
            return true;
        }
        return false;
    }
    
    public boolean hasLeftChild(Node current){
        if(current.left!=null){
            return true;
        }
        return false;
    }

    public boolean hasRightChild(Node current){
        if(current.right!=null){
            return true;
        }
        return false;
    }
	
	public void postOrderTraversal(Node root) {
		// Left-Right-Root
		if(root!=null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.printf(" %d ", root.key);
		}
	}
	
	

}
