package hashtable;

public class Node {
    
    public String key;
    public String value;
    Node next; // Used for seperate chaining
    
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}



