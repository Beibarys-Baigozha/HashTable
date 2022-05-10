public class Main {

    public static void main(String[] args) {
        MyHashTable<Integer, String> obj = new MyHashTable<Integer, String>();
        obj.put(1, "B");
        obj.printAll();
    }
}

