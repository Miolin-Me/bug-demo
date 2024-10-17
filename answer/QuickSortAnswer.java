package answer;

import java.util.Arrays;

public class QuickSortAnswer {

    static void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = low;

            for (int j = low; j < high; j++) {
                if (arr[j] <= arr[high])
                    swap(arr, pi++, j);
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
