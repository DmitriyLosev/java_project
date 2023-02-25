import java.util.Arrays;
public class heapSort {
    public static void main(String args[]) {
        int arrA[] = { 8, 6, 3, 1, 9, 5, 2, 4, 7 };
        System.out.println();
        System.out.println("*Массив до сортировки: " + Arrays.toString(arrA));
        heapSort hs = new heapSort();
        hs.sort(arrA);
        System.out.println();
        System.out.println("*Массив после сортировки: " + Arrays.toString(arrA));
        System.out.println();
    }
    public void sort(int array[]) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(array, size, i);
        for (int i = size - 1; i >= 0; i--) {
            int a = array[0];
            array[0] = array[i];
            array[i] = a;
            heapify(array, i, 0);
        }
    }
    void heapify(int array[], int heapSize, int i) {
        int large = i;
        int oneIndex = 2 * i + 1;
        int finIndex = 2 * i + 2;
        if (oneIndex < heapSize && array[oneIndex] > array[large])
            large = oneIndex;
        if (finIndex < heapSize && array[finIndex] > array[large])
            large = finIndex;
        if (large != i) {
            int swap = array[i];
            array[i] = array[large];
            array[large] = swap;
            heapify(array, heapSize, large);
        }
    }
}