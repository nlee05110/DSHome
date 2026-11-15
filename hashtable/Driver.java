package hashtable;

public class Driver {
    public static void main(String[] args) {
        HashTable table = new HashTable(23);
        table.put("Email", "nlee5@uafs.edu");
        table.put("Name","Nicholas");
        table.show();
    }
}
