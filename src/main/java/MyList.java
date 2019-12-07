import java.util.Collection;
import java.util.Iterator;

/**
 * Myself interface ArrayList
 */
public interface MyList<E> extends Collection<E>{
    boolean add(E e);
    void add(int index, E element);
    boolean addAll(Collection<? extends E> collection);
    boolean addAll(int index, Collection<? extends E> collection);
    E remove(int index);
    boolean remove(Object o);
    boolean removeAll(Collection<?> collection);
    void clear();
    int size();
    MyIterator<E> iterator();

}
