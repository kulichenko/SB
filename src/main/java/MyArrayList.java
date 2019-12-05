/**
 * Myself ArrayList implementation
 */

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<E> implements MyList<E> {
    private E[] values;

    public MyArrayList() {
        values = (E[])new Object();
    }

    public Iterator<E> iterator() {
        return null;
    }

    public void forEach(Consumer<? super E> action) {

    }

    public Spliterator<E> spliterator() {
        return null;
    }
}
