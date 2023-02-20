import java.util.Arrays;
public class mergeSorting {
    public static void main(String[] args) {
        int[] array = { 9, 5, 7, 3, 2, 4, 1, 6, 8 };
        int[] result = mergesort(array);
        System.out.println("Массив беспорядочных чисел:" + Arrays.toString(array));
        System.out.print("Массив отсортированный:" + Arrays.toString(result));
    }
    public static int[] mergesort(int[] array) {
        int[] buffer1 = Arrays.copyOf(array, array.length);
        int[] buffer2 = new int[array.length];
        int[] result = mergesort(buffer1, buffer2, 0, array.length);
        return result;
    }

    public static int[] mergesort(int[] buffer1, int[] buffer2,
                                       int oneIndex, int finIndex) {
        if (oneIndex >= finIndex - 1) {
            return buffer1;
        }

        int middle = oneIndex + (finIndex - oneIndex) / 2;
        int[] sorted1 = mergesort(buffer1, buffer2, oneIndex, middle);
        int[] sorted2 = mergesort(buffer1, buffer2, middle, finIndex);

        // Слияние
        int index1 = oneIndex;
        int index2 = middle;
        int targetIndex = oneIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < finIndex) {
            result[targetIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[targetIndex++] = sorted1[index1++];
        }
        while (index2 < finIndex) {
            result[targetIndex++] = sorted2[index2++];
        }
        return result;
    }
}