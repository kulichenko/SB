import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

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
        assertEquals(new Integer(3), list.get(3));
    }

    @Test
    void addAllByIndexTest() {
        MyList<String> list1 = new MyLinkedList<>();
        MyList<String> list2 = new MyLinkedList<>();
        list1.add("vehicle");
        list1.add("car");
        list2.add("bicycle");
        list2.add("tricycle");
        boolean result = list1.addAll(1, list2);
        assertTrue(result);
        assertEquals(4, list1.size());
        assertEquals("vehicle", list1.get(0));
        assertEquals("car", list1.get(3));
    }

    @Test
    void addAllTest() {
        MyList<String> list1 = new MyLinkedList<>();
        MyList<String> list2 = new MyLinkedList<>();
        list1.add("vehicle");
        list1.add("car");
        list2.add("bicycle");
        list2.add("tricycle");
        boolean result = list1.addAll(list2);
        assertTrue(result);
        assertEquals(4, list1.size());
        assertEquals("vehicle", list1.get(0));
        assertEquals("tricycle", list1.get(3));
    }

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
    void removeByIndexTest() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        Integer result = list.remove(1);
        assertEquals(new Integer(1), result);
        assertEquals(2, list.size());
        assertEquals(new Integer(2), list.get(1));
    }

    @Test
    void removeAllTest() {
        MyList<String> list1 = new MyLinkedList<>();
        MyList<String> list2 = new MyLinkedList<>();
        list1.add("vehicle");
        list1.add("car");
        list1.add("auto");
        list1.add("vehicle");
        list2.add("bicycle");
        list2.add("tricycle");
        list2.add("vehicle");
        boolean result = list1.removeAll(list2);
        assertTrue(result);
        assertEquals(2, list1.size());
        assertEquals("car", list1.get(0));
        assertEquals("auto", list1.get(1));
    }


    @Test
    void clearTest() {
        MyList<String> list1 = new MyLinkedList<>();
        assertEquals(0, list1.size());
        list1.add("vehicle");
        list1.add("car");
        list1.add("auto");
        assertEquals(3, list1.size());
        list1.clear();
        assertEquals(0, list1.size());
    }

    @Test
    void sizeTest() {
        MyList<String> list1 = new MyLinkedList<>();
        assertEquals(0, list1.size());
        list1.add("vehicle");
        list1.add("car");
        list1.add("auto");
        assertEquals(3, list1.size());
    }

    @Test
    void iteratorTest() {
        MyList<Integer> list = new MyLinkedList<>();
        assertFalse(list.iterator().hasNext());
        list.add(1);
        assertTrue(list.iterator().hasNext());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        int counter = 0;
        while (it.hasNext()) {
            it.next();
            counter++;
        }
        assertEquals(11, counter);
    }
}