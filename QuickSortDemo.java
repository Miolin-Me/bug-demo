import java.util.Arrays;

/**
 * 小故事：小明参加爱奇艺一面时，挂在了一道要求手写快速排序的编程题上
 * 错误输出：0000000000
 * 找出产生错误的位置并给出最佳修改方案 注：不要改变异或交换的思路
 */
public class QuickSortDemo {
    //使用异或交换元素
    static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = low;
            for (int j = low; j < high; j++) {
                if (arr[j] <= arr[high]) {
                    swap(arr, pi++, j);
                }
            }
            swap(arr, pi, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
