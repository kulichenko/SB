//Написать собственную реализацию ArrayList.
//Написать собственную реализацию LinkedList.
//Каждая реализация структуры данных должна уметь работать с различными типами данных.
//В каждой реализации должна быть возможность добавить элемент в структуру данных,
//добавить все элементы любой коллекции, удалить элемент из структуры данных, удалить
//все элементы указанной коллекции, очистить коллекцию и вернуть количество элементов в коллекции.
//Каждая коллекция должна реализовывать интерфейс Iterable и создавать свою реализацию итератора.
//Классы должны быть покрыты юнит тестами. В конце необходимо провести сравнение двух структур
// V add(E e)
// V add(int index, E element)
// V addAll(Collections<? extends E>)
// V addAll(Collections<int index, ? extends E>)
// V remove(int index)
// remove(Object o)
// removeAll(Collection<?> c)
// V clear()
// V size()
// V iterator()

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
    public boolean remove(Object o) {
        Node<E> node = first;
        while (node != null) {
            if (o.equals(node.element)) {
                E element = node.element;
                Node<E> next = node.next;
                Node<E> prev = node.prev;
                if (prev == null) {
                    first = next;
                } else {
                    prev.next = next;
                    node.prev = null;
                }

                if (next == null) {
                    last = prev;
                } else {
                    next.prev = prev;
                    node.next = null;
                }
                node.element = null;
                size--;
                return true;
            }
            node = node.next;

        }
        return false;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            addLast(element);
        } else {
            linkBefore(element, findNodeByIndex(index));
        }
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        for (E elem : c) {
            add(index++, elem);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public E remove(int index) {
        Node<E> removableElement = findNodeByIndex(index);
        E e = removableElement.element;
        Node<E> next = removableElement.next;
        Node<E> prev = removableElement.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            removableElement.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            removableElement.next = null;
        }

        removableElement.element = null;
        size--;
        return e;
    }

    @Override
    public boolean removeAll(Collection collection) {
        for (Object o : collection) {
            while (remove(o)) ;
        }
        return true;
    }

    private void addLast(E e) {
        Node<E> temp = last;
        Node<E> newNode = new Node<>(temp, e, null);
        last = newNode;
        if (temp == null) {
            first = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        Node<E> node = first;
        while (node != null) {
            Node<E> temp = node;
            node = node.next;
            temp.element = null;
            temp.next = null;
        }
        first = null;
        last = null;
        size = 0;
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return findNodeByIndex(index).element;
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
                return findNodeByIndex(index++).element;
            }
        };
    }


    Node<E> findNodeByIndex(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    private void linkBefore(E e, Node<E> succ) {
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
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;

        for (Node x = first; x != null; x = x.next) {
            result[i++] = x.element;
        }

        return result;
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
}