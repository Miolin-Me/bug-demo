import java.util.Arrays;

/**
 * 快速排序的结果有点诡异，麻烦找出解决方法吧，尽可能不要改变swap异或交换的思路来解决问题
 */
public class QuickSortDemo {

    //使用异或的方法进行元素交换
    static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }


    static void example() {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        example();
    }
}
