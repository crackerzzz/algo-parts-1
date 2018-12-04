import java.util.Iterator;

public class Stack<E> implements Iterable<E> {
    private Node first;
    private int N = 0;

    public void push(E item) {
        final Node oldfirst = first;
        first = new Node(item);
        first.next = oldfirst;
        N++;
    }

    public E pop() {
        final E item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            final E item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        E item;
        Node next;

        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
//        System.out.println(" stack.pop();: " + stack.pop());
        stack.push("3");
        stack.push("4");
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
//        System.out.println(" stack.pop();: " + stack.pop());
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
//        System.out.println(" stack.pop();: " + stack.pop());
//        System.out.println(" stack.pop();: " + stack.pop());
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
        for (String item : stack) {
            System.out.println(item);
        }
    }

}
