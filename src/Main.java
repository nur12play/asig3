public class Main {
    public static void main(String[] args) {
        BST<String, Integer> tree = new BST<>();
        tree.put("apple", 10);
        tree.put("banana", 20);
        tree.put("cherry", 30);
        tree.put("date", 40);

        System.out.println("Size of tree: " + tree.size());

        for (String elem : tree.iterator()) {
            System.out.println(elem);
        }

        tree.delete("banana");

        System.out.println("Size of tree after deletion: " + tree.size());

        for (String elem : tree.iterator()) {
            System.out.println(elem);
        }
    }
}
