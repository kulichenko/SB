import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {


    @Test
    void addTest() {
        MyList<String> list = new MyArrayList<>();
        boolean result = list.add("blue");
        assertTrue(result, "Результат добавления должен быть true");
        assertEquals("blue", list.get(0), "Первый элемент должен содержать добавляемый элемент");
        assertEquals(1, list.size(), "Список должен состоять из одного элемента");
        list.add("brown");
        assertEquals("brown", list.get(list.size() - 1), "Последний добавленный элемент должен быть в конце list");
    }

    @Test
    void addByIndexTest() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(1, 15);
        assertNotNull(list, "list не должен быть пустым");
        assertEquals(new Integer(15), list.get(1), "Элемент под индексом 1 должен быть равен последнему вставленному элементу (15)");
        assertEquals(new Integer(3), list.get(3), "Последний элемент list должен быть равен (3)");
        assertEquals(4, list.size(), "Размер list должен быть равен 4");

    }

    @Test
    void addAllTest() {
        MyList<Character> characters1 = new MyArrayList<>();
        MyList<Character> characters2 = new MyArrayList<>();
        for (char a = 'a'; a < 'c'; a++) {
            characters1.add(a);
        }

        for (char c = 'c'; c < 'f'; c++) {
            characters2.add(c);
        }
        boolean result = characters1.addAll(characters2);
        assertTrue(result, "Результат добавления должен быть true");
        assertEquals(new Character('a'), characters1.get(0), "Первый элемент должен содержать 'a'");
        assertEquals(new Character('e'), characters1.get(characters1.size() - 1), "Последний элемент должен содержать 'f'");
        assertEquals(5, characters1.size(), "Размер characters должен быть равен 5");

    }

    @Test
    void addAllByIndexTest() {
        MyList<Character> characters1 = new MyArrayList<>();
        MyList<Character> characters2 = new MyArrayList<>();
        for (char a = 'a'; a < 'c'; a++) {
            characters1.add(a);
        }

        for (char c = 'c'; c < 'f'; c++) {
            characters2.add(c);
        }
        boolean result = characters1.addAll(1, characters2);
        assertTrue(result, "Результат добавления должен быть true");
        assertEquals(new Character('a'), characters1.get(0), "Первый элемент должен содержать 'a'");
        assertEquals(new Character('b'), characters1.get(characters1.size() - 1), "Последний элемент должен содержать 'b'");
        assertEquals(5, characters1.size(), "Размер characters должен быть равен 5");
    }

    @Test
    void removeByIndexTest() {
        MyList<String> list = new MyArrayList<>();
        list.add("open");
        list.add("close");
        String result = list.remove(1);
        assertEquals("close", result);
        assertEquals(1, list.size());
        assertEquals("open", list.get(0));

    }

    @Test
    void removeObjectTest() {
        MyList<String> list = new MyArrayList<>();
        list.add("street");
        list.add("building");
        list.add("window");
        String removableObject = "street";
        boolean result = list.remove(removableObject);
        assertTrue(result, "Результат добавления должен быть true");
        assertEquals(2, list.size());
        assertEquals("building", list.get(0));
    }

    @Test
    void removeAllTest() {
        MyList<String> list1 = new MyArrayList<>();
        list1.add("street");
        list1.add("building");
        list1.add("building");
        list1.add("window");
        MyList<String> list2 = new MyArrayList<>();
        list2.add("street");
        list2.add("building");
        list2.add("road");
        list1.removeAll(list2);
        assertEquals(1, list1.size());
        assertEquals("window", list1.get(0));
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
        Iterator<Integer> iter = list.iterator();
        int counter = 0;
        while (iter.hasNext()) {
            iter.next();
            counter++;
        }
        assertEquals(11, counter);
    }

    @Test
    void clearTest() {
        MyList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
        list.clear();
        assertEquals(0, list.size());
        assertNull(list.get(0));
    }

    @Test
    void sizeTest() {
        MyList<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(101, list.size());
    }
}