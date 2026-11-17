package hashtable;

public class Driver {
    public static void main(String[] args) {
        HashTable table = new HashTable(23);
        table.put("08", "nlee5@uafs.edu");
        table.put("18", "jason05@uafs.edu");
        table.put("36", "susan03@uafs.edu");
        table.put("12", "jessica89@uafs.edu");
        table.put("01", "blake08@uafs.edu");
        table.put("23", "timothy34@uafs.edu");
        table.show();
        System.out.printf("Value: %s", table.get("23"));
    }
}
