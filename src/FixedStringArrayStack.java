import java.util.Iterator;

public class FixedStringArrayStack implements Iterable<String> {
    private String[] items;
    private int N = 0;

    public FixedStringArrayStack(int capacity) {
        items = new String[capacity];
    }

    public void push(String item) {
        items[N++] = item;
    }

    public String pop() {
        final String item = items[--N];
        items[N] = null;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<String> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<String> {
        private int currentN = N;

        @Override
        public boolean hasNext() {
            return currentN != 0;
        }

        @Override
        public String next() {
            return items[--currentN];
        }
    }

    public static void main(String[] args) {
        FixedStringArrayStack stack = new FixedStringArrayStack(10);
        stack.push("1");
        stack.push("2");
        for (String item : stack) {
            System.out.println(item);
        }
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
        System.out.println(" stack.pop();: " + stack.pop());
        stack.push("3");
        stack.push("4");
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
        System.out.println(" stack.pop();: " + stack.pop());
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
        System.out.println(" stack.pop();: " + stack.pop());
        System.out.println(" stack.pop();: " + stack.pop());
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
    }

}
