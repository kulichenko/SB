import java.util.ArrayList;
import java.util.List;

public class TestJavaLists {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        for (String s :
                strings) {
            System.out.println(s);
        }
        strings.add("jlnsd");
        strings.add("jlnsd");
        strings.add("jlnsd");
        strings.add("jlnsd");

        for (String s: strings){
            System.out.println(s);

        }
    }
}
