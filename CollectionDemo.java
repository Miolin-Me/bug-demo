import java.util.*;


/**
 * 小明同学开发时遇到一个场景，他需要将数组中的某个可能重复的元素全部放到列表尾，返回类型为列表
 * 修复出现的bug
 */
public class CollectionDemo {

    static List<Object> example(Object[] arr, Object target) {
        List<Object> list = Arrays.asList(arr);
        removeAndAdd(list, target);

        return list;
    }

    static void removeAndAdd(List<Object> list, Object target) {
        int counter = 0;
        for (Object str : list) {
            if(Objects.equals(str, target)) {
                list.remove(str);
                counter += 1;
            }
        }

        while (counter-- != 0) {
            list.add(target);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "orange", "apple", "pear", "pineapple"};
        String target = "apple";
        List<Object> list = example(arr, target);
        System.out.println(list.toString());
    }
}
