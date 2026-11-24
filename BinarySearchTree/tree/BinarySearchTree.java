package tree;

public class BinarySearchTree {
	Node root;
    int leaves;
    int height;
	
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
        if(current==null){
            return current;
        }
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
        if(current.right!=null && value == current.right.key)  {
            if(hasChildren(current.right)){
                deleteRightChild(current); 
            } else {
                current.right = null;
            }
            return current;
       } 
        if(current.left!=null && value == current.left.key){
            if(hasChildren(current.left)){
                deleteLeftChild(current);
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
	
    public void deleteLeftChild(Node current) {
        
        if(hasLeftChild(current.left)&&hasRightChild(current.left)){
            Node temp = current.left.left;    
            current.left = current.left.right;
            if(hasChildren(current.left)){
                Node lowestLeftNode = lowestLeftNode(current.left);
                lowestLeftNode.left = temp;
                return;
            }
            current.left.left = temp;
        } else if(hasLeftChild(current.left)&&!hasRightChild(current.left)){
            current.left = current.left.left;    
        } else if(!hasLeftChild(current.left)&&hasRightChild(current.left)){
            current.left = current.left.right;    
        } 
    }    
    public void deleteRightChild(Node current) {
        if(hasLeftChild(current.right)&&hasRightChild(current.right)){
            Node temp = current.right.left;    
            current.right = current.right.right;
            if(hasLeftChild(current.right)){
                Node lowestLeftNode = lowestLeftNode(current.right);
                lowestLeftNode.left = temp;
                return;
            }
            current.right.left = temp;
        } else if(hasLeftChild(current.right)&&!hasRightChild(current.right)){
            current.right = current.right.left;    
        } else if(!hasLeftChild(current.right)&&hasRightChild(current.right)){
            current.right = current.right.right;    
        }        
    }
	
	public int findMin() {
        return findMin(this.root);
	}
	//****** Find Minimum Key Value ***************************
	public int findMin(Node node) {
        if(node.left==null){
            return node.key;
        } else {
            return findMin(node.left);
        }
	}
	
	//****** Height (Count in Nodes) ***************************
	public int height(Node root) {
    	return 0;
    }
    
    //****** Count Leaves ***************************
    public int getLeaves(){
        leaves = countLeaves(root);
        return leaves;
    }
	public int countLeaves(Node root) {
        if(root.left!=null&&root.right!=null){
            countLeaves(root.left);
            countLeaves(root.right);
        } else {
            leaves +=1;
        }
		return leaves;
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
            if(hasChildren(root)&&hasRightChild(root)&&hasLeftChild(root)){
			    System.out.printf("VAL: %d LEFT: %d RIGHT: %d\n", root.key, root.left.key, root.right.key);
            }else if(hasRightChild(root)){
			    System.out.printf("VAL: %d LEFT: NULL RIGHT: %d\n", root.key, root.right.key);
            }else if(hasLeftChild(root)){
			    System.out.printf("VAL: %d LEFT: %d RIGHT: NULL\n", root.key, root.left.key);
            } else {
			    System.out.printf("VAL: %d LEFT: NULL RIGHT: NULL\n", root.key);
            }
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
    public Node lowestLeftNode(Node current){
        if(current.left==null){
            return current;
        }
        return lowestLeftNode(current.left);
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
