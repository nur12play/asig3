public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int hashTableSize;

    public MyHashTable(int size) {
        this.hashTableSize = size;
        chainArray = new HashNode[size];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % hashTableSize;
    }


    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (chainArray[index] != null) {
            newNode.next = chainArray[index];
        }
        chainArray[index] = newNode;
    }

    public void remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean contains(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < hashTableSize; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }

    public void printTable() {
        for (int i = 0; i < hashTableSize; i++) {
            HashNode<K, V> current = chainArray[i];
            if (current != null) {
                System.out.print("Bucket " + i + ": ");
                while (current != null) {
                    System.out.print(current.toString() + " ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }
}
