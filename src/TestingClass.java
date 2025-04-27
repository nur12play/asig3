public class TestingClass {
    public static void main(String[] args) {
        MyHashTable<String, Integer> table = new MyHashTable<>(10);

        table.put("apple", 10);
        table.put("banana", 20);
        table.put("cherry", 30);
        table.put("date", 40);
        table.put("elderberry", 50);

        table.printTable();

        System.out.println("Contains 'banana': " + table.contains("banana"));

        System.out.println("Key for value 30: " + table.getKey(30));

        table.remove("banana");
        System.out.println("Contains 'banana' after removal: " + table.contains("banana"));

        table.printTable();
    }
}
