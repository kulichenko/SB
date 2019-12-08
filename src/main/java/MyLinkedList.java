//Написать собственную реализацию ArrayList.
//Написать собственную реализацию LinkedList.
//Каждая реализация структуры данных должна уметь работать с различными типами данных.
//В каждой реализации должна быть возможность добавить элемент в структуру данных,
//добавить все элементы любой коллекции, удалить элемент из структуры данных, удалить
//все элементы указанной коллекции, очистить коллекцию и вернуть количество элементов в коллекции.
//Каждая коллекция должна реализовывать интерфейс Iterable и создавать свою реализацию итератора.
//Классы должны быть покрыты юнит тестами. В конце необходимо провести сравнение двух структур
// add(E e)
// add(int index, E element)
// addAll(Collections<? extends E>)
// addAll(Collections<int index, ? extends E>)
// remove(int index)
// remove(Object o)
// removeAll(Collection<?> c)
// clear()
// size()
// iterator()

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E>, Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index >= 0 && index <= this.size) {
            if (index == size) {
                linkLast(element);
            } else {
                linkBefore(element, node(index));
            }
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            return node(index).element;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    Node<E> node(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void linkFirst(E e) {
        Node<E> firstTemp = first;
        Node<E> newNode = new Node<>(null, e, firstTemp); //новый узел, ссылка prev -> null, вставляемый текущий элемент e, ссылка на next -> бывшийFirst
        first = newNode;
        if (firstTemp == null) { //если первый узел null,
            last = newNode;//присваиваем новый узел last-у
        } else {
            firstTemp.prev = newNode;
        }
        size++;
    }

    void linkLast(E e) {
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(oldLast, e, null);//новый узел, ссылка prev -> на бывший узелLast, вставляемый текущий элемент e, ссылка на next -> null
        last = newNode;
        if (oldLast == null) {
            first = newNode;
        } else {
            oldLast.next = newNode;
        }
        size++;
    }

    void linkBefore(E e, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    private class Node<E> {

        Node<E> prev;
        E element;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }
}