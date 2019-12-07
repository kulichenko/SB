
public class Tests {
    public static void main(String[] args) {
        MyList<String> strings1 = new MyArrayList<>();
        MyList<String> strings2 = new MyArrayList<>();
        strings1.add("lake");
        System.out.println(strings1.size());
        strings1.add("second");
        strings1.add("white");
        strings1.add("green");
        strings1.add("blue");
        strings1.add("first");
        strings1.add("second");
        strings1.add("white");
        strings1.add("night");
        strings1.add("day");
        strings1.add("every");
        strings1.add("blue"); //index = 9
        System.out.println("strings1 " + strings1);
        System.out.println("size: " + strings1.size());
        strings2.add("forest");//index = 0
        strings2.add("car");//index = 1
        strings2.add("elipse");//index = 2
        strings2.add("future");//index = 3
        System.out.println("strings2 " + strings2);
        System.out.println("size: " + strings2.size());
        MyList<String> strings3 = new MyArrayList<>();
        strings3.addAll(strings1);
        System.out.println("strings3 " + strings3);
        System.out.println("size: " + strings3.size());
        strings2.addAll(2, strings3);
        System.out.println("strings2 " + strings2);
        System.out.println("size: " + strings2.size());
        strings2.removeAll(strings1);
        System.out.println("strings2 " + strings2);
        System.out.println("size: " + strings2.size());
        strings2.addAll(strings3);
        strings2.add("boat");
        strings2.add(5, "5");
        System.out.println("strings2 " + strings2);
        System.out.println("size: " + strings2.size());
        strings2.removeAll(strings1);
        System.out.println("strings2 " + strings2);
        System.out.println("size: " + strings2.size());
        }
    }