//Написать собственную реализацию ArrayList.
//Каждая реализация структуры данных должна уметь работать с различными типами данных.
//В каждой реализации должна быть возможность добавить элемент в структуру данных,
//добавить все элементы любой коллекции, удалить элемент из структуры данных, удалить
//все элементы указанной коллекции, очистить коллекцию и вернуть количество элементов в коллекции.
//Каждая коллекция должна реализовывать интерфейс Iterable и создавать свою реализацию итератора.
//Классы должны быть покрыты юнит тестами. В конце необходимо провести сравнение двух структур
//V add(E e)
//V add(int index, E element)
//V addAll(Collections<? extends E>)
//V addAll(Collections<int index, ? extends E>)
//V remove(int index)
//V remove(Object o)
//V removeAll(Collection<?> c)
//V clear()
//V size()
//V iterator()

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Myself ArrayList implementation
 */

public class MyArrayList<E> implements MyList<E> {
    private E[] elements;
    private int size;

    public MyArrayList() {
        this.elements = (E[]) new Object[10];
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     */
    @Override
    public boolean add(E e) {
        upLengthOfArray();
        elements[size++] = e;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     */
    @Override
    public void add(int index, E element) {
            upLengthOfArray();
        E[] tempArray1 = Arrays.copyOf(elements, index);
        E[] tempArray2 = Arrays.copyOfRange(elements, index, size);
        elements[index] = element;
        System.arraycopy(tempArray1, 0, elements, 0, tempArray1.length);
        System.arraycopy(tempArray2, 0, elements, index + 1, tempArray2.length);
        size++;
    }

    /**
     * Appends all of the elements in the specified
     * collection to the end of this list, in the order
     * that they are returned by the specified collection's Iterator.
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E c : collection) {
                upLengthOfArray();
            elements[size++] = c;
        }
        return true;
    }

    /**
     * Inserts all of the elements in the specified collection into this list, starting at the specified position.
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        E[] tempArray1 = Arrays.copyOf(elements, index);
        E[] tempArray2 = Arrays.copyOfRange(elements, index, size);
        for (E c : collection) {
                upLengthOfArray();
            elements[index] = c;
            System.arraycopy(tempArray1, 0, elements, 0, tempArray1.length);
            System.arraycopy(tempArray2, 0, elements, index + 1, tempArray2.length);
            size++;
            index++;
        }
        return true;
    }

    /**
     * Removes the element at the specified position in this list.
     */
    @Override
    public E remove(int index) {
        E oldValue = elements[index];
        E[] tempArray1 = Arrays.copyOf(elements, index);
        E[] tempArray2 = Arrays.copyOfRange(elements, index + 1, elements.length);
        elements = (E[]) new Object[elements.length - 1];
        System.arraycopy(tempArray1, 0, elements, 0, tempArray1.length);
        System.arraycopy(tempArray2, 0, elements, index, tempArray2.length);
        size--;
        return oldValue;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     */
    @Override
    public boolean remove(Object o) {
        int index;

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o)) {
                index = i;
                E[] tempArray1 = Arrays.copyOf(elements, index);
                E[] tempArray2 = Arrays.copyOfRange(elements, index + 1, elements.length);
                elements = (E[]) new Object[elements.length - 1];
                System.arraycopy(tempArray1, 0, elements, 0, tempArray1.length);
                System.arraycopy(tempArray2, 0, elements, index, tempArray2.length);
                size--;
                return true;
            } else if (i == elements.length - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object c : collection) {
            for (E e : elements) {
                if (c.equals(e)) {
                    remove(e);
                }
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {

                return index < size;
            }

            @Override
            public E next() {
                return elements[index++];
            }
        };
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < elements.length; i++) {
                if (o.equals(elements[i])) {
                    return true;
                }
            }
        return false;
    }
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i] + " ");
        }
        return "[" + sb.toString() + "]";
    }

    private boolean upLengthOfArray() {
        if (size == elements.length) {
            E[] tempArray = elements;
            elements = (E[]) new Object[tempArray.length * 2];
            System.arraycopy(tempArray, 0, elements, 0, tempArray.length);
            return true;
        }
        return false;
    }
}