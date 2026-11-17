
package hashtable;
public class HashTable {
    int size;
    int loadfactor;
    int capacity;
    Node[] table;

    public HashTable(int capacity) {
        this.size =0;
        this.capacity=capacity;
        this.table = new Node[capacity];
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
        if(!isHashEmpty(hash)){
            seperateChaining(node, hash);
            //linearProbing(node, hash);
            return;
        }
        this.table[hash] = node;
        this.size++;
        this.loadfactor = this.size/this.capacity;
    }

    public String get(String key) {
        String str = null;
        Node curNode; 
        int hash = hashkey(key);
        if(this.table[hash]!=null){
             if(this.table[hash].key != key){
                    curNode = this.table[hash];
                    str = getChainNodeValue(curNode, key);
            } else {
                str=this.table[hash].value;
            }
        }

        if(str==null) return "ERR: String or Value NOT FOUND";
        return str;
    }

    public String getChainNodeValue(Node curNode, String key) {
        while(curNode.next!=null){
            if(curNode.next.key==key){
                return curNode.next.value;
            }
        }
        return null; 
    }

    public void linearProbing(Node node, int hash) {
        int index = hash;
        while(this.table[index]!=null){
            if(index >= capacity-1){
                index = 0; 
            } else {
                index++;
            }
        }
        this.table[index] = node;
        this.size++;
    }

    public void seperateChaining(Node node, int hash){
        if(this.table[hash].next != null){
            node.next = this.table[hash].next;
            this.table[hash].next = node; 
        } else {
            this.table[hash].next = node; 
        }
    }

    public void showChaining(Node node) {
        Node curNode = node.next; 
        while(curNode!=null){
	        System.out.printf(" -------> Key: %s | Value: %s", 
                    curNode.key,curNode.value);
            curNode=curNode.next;
            
        }
    }

    public boolean isHashEmpty(int hash) {
        if(this.table[hash]==null) return true;
        return false;
    }
	public void show() {
		int index;
		
		System.out.printf("\nLoad Factor: %3.2f\n", (float)this.size/this.capacity);
		System.out.printf("--------------------------\n");
		for(index=0;index<this.capacity;index++) {
			if(this.table[index]!=null) {
				System.out.printf("[%d]: Key: %s | Value: %s", index, table[index].key,table[index].value);
                if(this.table[index].next!=null){
                    showChaining(table[index]);
                }
                System.out.println();
			}else {
				System.out.printf("[%d]: NULL\n", index);
			}
		}
	}
}
