import org.junit.jupiter.api.Test;

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
        assertEquals("brown", list.get(list.size()-1), "Последний добавленный элемент должен быть в конце list");
    }

    @Test
    void addByIndex() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(1, 15);
        assertNotNull(list, "list не должен быть пустым");
        assertEquals(new Integer(15), list.get(1), "Элемент под индексом 1 должен быть равен последнему вставленному элементу (15)");
        assertEquals(new Integer(3), list.get(3), "Последний элемент list должен быть равен (3)");
        assertEquals(4, list.size(), "Размер list должен быть равен 4");

    }

    @Test
    void addAll() {
        MyList<Character> characters1 = new MyArrayList<>();
        MyList<Character> characters2 = new MyArrayList<>();
        for (char a = 'a'; a<'d'; a++){
            characters1.add(a);
        }
        for (char c = 'e'; c<'g'; c++){
            characters2.add(c);
        }
        characters1.addAll(characters2);
        assertEquals(new Character('a'), characters1.get(0), "");
        assertEquals(new Character('f'), characters1.get(characters1.size()-1), "");

    }

    @Test
    void addAll1() {
    }

    @Test
    void remove() {
    }

    @Test
    void remove1() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void iterator() {
    }

    @Test
    void clear() {
    }

    @Test
    void size() {
    }
}