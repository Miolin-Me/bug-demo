package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CollectionAnswer {

    static List<Object> removeElement(Object[] arr, Object target) {
        List<Object> list = new ArrayList<>(Arrays.asList(arr));
        list.removeIf(str -> Objects.equals(str, target));
        return list;
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "orange", "apple", "pear", "pineapple"};
        String target = "apple";
        System.out.println(removeElement(arr, target).toString());
    }
}
