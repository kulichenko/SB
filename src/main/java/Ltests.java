public class Ltests {
    public static void main(String[] args) {
        MyList<String> integers1 = new MyLinkedList<>();
        integers1.add("0");
        integers1.add("1");
        integers1.add("2");
        integers1.add("3");
        System.out.println();
        System.out.println("size: " + integers1.size());
        for (String integer : integers1) {
            System.out.print(integer + " ");
        }

        MyList<String> integers2 = new MyLinkedList<>();
        integers2.add("5");
        integers2.add("6");
        integers2.add("7");
        integers2.add("8");
        System.out.println();
        System.out.println("size: " + integers2.size());
        for (String integer : integers2) {
            System.out.print(integer + " ");
        }
        integers1.addAll(0, integers2);
        System.out.println();
        System.out.println("size: " + integers1.size());

        for (String integer : integers1) {
            System.out.print(integer + " ");
        }
        integers1.clear();
        for (String integer : integers1) {
            System.out.print(integer + " ");
        }
    }
}
