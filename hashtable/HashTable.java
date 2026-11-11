package hashtable;

public class HashTable {
    private int size;
    private Node[] nodes;

    public HashTable(int size) {
        this.size = size;
        this.nodes = new Node[size];
    }
}
