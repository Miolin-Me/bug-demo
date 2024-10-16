import java.util.*;

/**
 * 小故事：新来的小明同学开发时遇到一个场景，他需要将数组中的目标元素全部删除，并返回列表。
 * removeElement中有两处会产生报错的bug，找出来并优化它们
 */
public class CollectionDemo {

    static List<Object> removeElement(Object[] arr, Object target) {
        List<Object> list = Arrays.asList(arr);
        for (Object str : list) {
            if(Objects.equals(str, target)) {
                list.remove(str);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "orange", "apple", "pear", "pineapple"};
        String target = "apple";
        System.out.println(removeElement(arr, target).toString());
    }
}
