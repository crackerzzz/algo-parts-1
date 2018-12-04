import java.util.Iterator;

public class ResizableStringArrayStack implements Iterable<String> {
    private String[] items;
    private int N = 0;

    public ResizableStringArrayStack() {
        items = new String[1];
    }

    public void push(String item) {
        if (N == items.length) {
            resize();
        }
        items[N++] = item;
    }

    private void resize() {
        System.out.println("Resizing to " + (items.length * 2));
        String[] newArray = new String[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
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
        ResizableStringArrayStack stack = new ResizableStringArrayStack();
        for (int i = 0; i < 100; i++) {
            stack.push("" + i);
        }
        for (String item : stack) {
            System.out.println(item);
        }
    }

}
