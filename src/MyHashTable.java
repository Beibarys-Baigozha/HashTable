public class MyHashTable<K, V> {
    private static class MyNode<K, V>{
        K key;
        V value;
        MyNode<K, V> next;

        MyNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private MyNode<K, V>[] buckets;
    private int capacity = 10;
    private int length = 0;
    private float loadFactor = 0.75F;

    public MyHashTable() {
        buckets = new MyNode[capacity];
    }

    public MyHashTable(int capacity) {
        capacity = (int)(capacity * loadFactor);
        buckets = new MyNode[capacity];
    }

    public void put(K key, V value) {
        MyNode<K, V> newNode = new MyNode<>(key, value);
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }
        length++;

        for (int i = 0; i < buckets.length; i++){
            MyNode<K, V> head = buckets[i];
            MyNode<K, V> newkey = head;
            while(newkey !=null) {
                if (newkey.equals(key)) ;
            }
        }
    }

    public V get(K key) {
        int index = hash(key);

        MyNode<K, V> it = buckets[index];
        while (it != null) {
            if (it.key.equals(key))
                return it.value;
            it = it.next;
        }

        return null;
    }

    public void printAll() {
        for (int i = 0; i < buckets.length; i++) {
            MyNode<K, V> it = buckets[i];
            while (it != null) {
                System.out.println(it.value + "("+ it.key.hashCode() +") ");
                it = it.next;
            }
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public V remove(K key) {
        int hash = hash(key);
        MyNode<K, V> head = buckets[hash];
        V removed = null;

        if (head == null) {
            System.out.println("List is empty. No such key.");
        } else if (head.key.equals(key)) {
            removed = head.value;
            buckets[hash] = head.next;
        } else {
            while (head.next != null) {
                if (head.next.key.equals(key)) {
                    removed = head.next.value;
                    head.next = head.next.next;
                    break;
                }
                head = head.next;
            }
        }
        return removed;
    }

    public boolean contains(V value) {
        for (int i = 0; i < buckets.length; i++){
            MyNode<K, V> head = buckets[i];
            MyNode<K, V> node = head;
            while(node!=null) {
                if (node.value.equals(value)) return true;
                else node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < buckets.length; i++){
            MyNode<K, V> head = buckets[i];
            MyNode<K, V> node = head;
            while(node!=null) {
                if (node.value.equals(value)) return node.key;
                else node = node.next;
            }
        }
        return null;
    }
}
