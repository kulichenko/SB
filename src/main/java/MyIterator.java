import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] elements;
    private int size;


    public MyIterator(E[] elements, int size) {
        this.elements = elements;
        this.size = size;
    }

    @Override
    public boolean hasNext() {

            return index < size;
    }

    @Override
    public E next() {
        return elements[index++];
    }
}
