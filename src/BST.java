public class BST<K extends Comparable <K>, V>{
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        Node newNode = new Node (key, value);
        root = put (root, newNode);
    }

    private Node put(Node current, Node newNode) {
        if(current==null) return newNode;
        if(newNode.key.compareTo(current.key) > 0)
            current.right = put(current.right, newNode);
        if(newNode.key.compareTo(current.key) < 0)
            current.left = put(current.left, newNode);
        return current;
    }

    public V get(K key) {
        return  get(root, key);
    }

    public V get(Node current, K key){
        if (current==null) return null;
        int cmp = key.compareTo(current.key);
        if (cmp < 0) return get(current.left, key);
        else if (cmp > 0) return get(current.right, key);
        else return current.value;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    public Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node current) {
        if (current.left == null) return current;
        return min(current.left);
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node current) {
        if (current.right == null) return current;
        return max(current.right);
    }

    private Node delete(Node current, K key)
    {
        if (current == null) return null;
        int cmp = key.compareTo(current.key);
        if (cmp < 0) current.left = delete(current.left, key);
        else if (cmp > 0) current.right = delete(current.right, key);
        else
        {
            if (current.right == null) return current.left;
            if (current.left == null) return current.right;
            Node t = current;
            current = min(t.right);
            current.right = deleteMin(t.right);
            current.left = t.left;
        }
        return current;
    }

    public Iterable<K> keys()
    { return keys(min(), max()); }
    public Iterable<K> keys(K lo, K hi)
    {
        MyQueue<K> queue = new MyQueue<K>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node current, MyQueue<K> queue, K lo, K hi)
    {
        if (current == null) return;
        int cmplo = lo.compareTo(current.key);
        int cmphi = hi.compareTo(current.key);
        if (cmplo < 0) keys(current.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(current.key);
        if (cmphi > 0) keys(current.right, queue, lo, hi);
    }

    private void print(Node current) {
        if (current == null) return;
        print(current.left);
        System.out.println(current.key);
        print(current.right);
    }
}
