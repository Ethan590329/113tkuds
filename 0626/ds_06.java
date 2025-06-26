
import java.util.Random;

public class ds_06 {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random rand = new Random();

        System.out.println("隨機產生的陣列元素：");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100); // 0~99
            System.out.print(numbers[i] + " ");
        }

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("\n陣列中的最大值為：" + max);
    }
}
