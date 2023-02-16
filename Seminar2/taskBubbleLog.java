import java.io.FileWriter;
import java.util.Arrays;
public class taskBubbleLog {
       public static void main(String[] args) {
        int[] arr = { 77, 55, 11, 00, 33, 88, 22, 99, 44, 66 };
        for (int j = arr.length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int num = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = num;
                }
            }
            try (FileWriter f = new FileWriter("log.txt", true)) {
                f.write(Arrays.toString(arr));
                f.write("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}