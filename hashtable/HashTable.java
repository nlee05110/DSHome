
package hashtable;
public class HashTable {
    int size;
    int capacity;
    Node[] nodes;

    public HashTable(int capacity) {
        this.size =0;
        this.capacity=capacity;
        this.nodes = new Node[capacity];
    }
    
    public int hashkey(String key) {
    	int index;
    	int total=0;
    	for(index=0;index<key.length();index++) {
    		total = total + (key.charAt(index) * 13);
    	}
        return total % this.capacity;
    }

    public void put(String key, String value) {
        int hash = hashkey(key);
        Node node = new Node(key, value);
        this.nodes[hash] = node;
        this.size++;
    }

    public String get(String key) {
        String str = null;
        int hash = hashkey(key);
        if(this.nodes[hash]!=null){
            str=this.nodes[hash].value;
            
        }
        return str;
    }
	public void show() {
		int index;
		
		System.out.printf("\nLoad Factor: %3.2f\n", (float)this.size/this.capacity);
		System.out.printf("--------------------------\n");
		for(index=0;index<this.capacity;index++) {
			if(this.nodes[index]!=null) {
				System.out.printf("[%d]: Key: %s Value %s\n", index, nodes[index].key,nodes[index].value);
			}else {
				System.out.printf("[%d]: NULL\n", index);
			}
		}
	}
}
