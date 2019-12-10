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
// clear()
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
    public boolean add(E e) {
        addLast(e);
        return true;
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
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
                for (E elem : c) {
                    add(index++, elem);}
                return true;
            }

    @Override
    public E remove(int index) {
            Node<E> removableElement = findNodeByIndex(index);
            E e = removableElement.element;
            Node<E> next = removableElement.next;
            Node<E> prev = removableElement.prev;       //first                                        last
            if (prev == null) {                 //[null<-element0->next][prev<-element1->next][prev<-element1->null]
                first = next;                   //[null<-element1->next][prev<-element1->null]
            } else {
                prev.next = next;               //[null<-element1->next][prev<-element1->next][prev<-element1->null]
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i<size;i++){
            findNodeByIndex(i).prev = null;
            findNodeByIndex(i).next = null;
            findNodeByIndex(i).element = null;
        }
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
//
//    private void addFirst(E e) {
//        Node<E> firstTemp = first;
//        Node<E> newNode = new Node<>(null, e, firstTemp);
//        first = newNode;
//        if (firstTemp == null) {
//            last = newNode;
//        } else {
//            firstTemp.prev = newNode;
//        }
//        size++;
//    }

    private void addLast(E e) {
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(oldLast, e, null);
        last = newNode;
        if (oldLast == null) {
            first = newNode;
        }
        else {
            oldLast.next = newNode;
        }
        size++;
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
    public boolean retainAll(Collection collection) {
        return false;
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