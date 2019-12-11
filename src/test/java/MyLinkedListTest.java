import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyLinkedListTest {

    @Test
    void removeObjectTest() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        Integer o = 1;
        boolean result = list.remove(o);
        assertTrue(result);
        assertEquals(2, list.size());
        assertEquals(new Integer(2), list.get(1));
    }

    @Test
    void addByIndexTest() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(3, list.size());
        list.add(1, 100);
        assertEquals(4, list.size());
        assertEquals(new Integer(100), list.get(1));
    }

    @Test
    void addObjectTest() {
        MyList<Integer> list = new MyLinkedList<>();
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(c);
        assertEquals(4, list.size());
        assertEquals(new Integer(2), list.get(1));
    }

    @Test
    void addAll() {
    }

    @Test
    void testAddAll() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void size() {
    }

    @Test
    void iterator() {
    }
}