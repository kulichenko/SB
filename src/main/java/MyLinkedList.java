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
        if (index >= 0 && index <= this.size) {
            if (index == size) {
                addLast(element);
            } else {
                linkBefore(element, node(index));
            }
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        if (index >= 0 && index <= size) {
            int sizeOfCollection = c.size();
            if (sizeOfCollection == 0) {
                return false;
            } else {
                Node<E> leftNode;
                Node<E> rightNode;
                if (index == size) {
                    rightNode = null;
                    leftNode = last;
                } else {
                    rightNode = node(index);
                    leftNode = rightNode.prev;
                }
                for (E elem : c) {
                    Node<E> newNode = new Node<>(leftNode, elem, null);
                    if (leftNode == null) {
                        first = newNode;
                    } else {
                        leftNode.next = newNode;
                    }
                    leftNode = newNode;
                }
                if (rightNode == null) {
                    last = leftNode;
                } else {
                    leftNode.next = rightNode;
                    rightNode.prev = leftNode;
                }
                size += sizeOfCollection;
                return true;
            }
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= size) {
            Node<E> removableElement = node(index);
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
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
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

    private void addFirst(E e) {
        Node<E> firstTemp = first;
        Node<E> newNode = new Node<>(null, e, firstTemp);
        first = newNode;
        if (firstTemp == null) {
            last = newNode;
        } else {
            firstTemp.prev = newNode;
        }
        size++;
    }

    void addLast(E e) {
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(oldLast, e, null);
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