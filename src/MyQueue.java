import java.util.Iterator;
import java.util.LinkedList;

public class MyQueue < T extends Comparable <T> > implements Iterable<T> {
    private LinkedList<T> queueNode;

    public int size() {
        return queueNode.size();
    }

    public boolean empty() {
        return (this.size() == 0) ? true : false;
    }

    public T enqueue(T newItem) {
        queueNode.add(newItem);
        return newItem;
    }

    public T dequeue() {
        return queueNode.remove(0);
    }

    public T peek() {
        return queueNode.get(0);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
