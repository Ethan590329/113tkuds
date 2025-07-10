public class ArrayStatistics {
    public static void main(String[] args) {

        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        double average;
        int max = numbers[0], min = numbers[0];
        int maxIndex = 0, minIndex = 0;
        int countAboveAvg = 0;
        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            sum += num;

            if (num > max) {
                max = num;
                maxIndex = i;
            }
            if (num < min) {
                min = num;
                minIndex = i;
            }

            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // 平均值
        average = (double) sum / numbers.length;
        for (int num : numbers) {
            if (num > average) {
                countAboveAvg++;
            }
        }
        System.out.println("===== 陣列統計分析結果 =====");
        System.out.printf("總和：%d\n", sum);
        System.out.printf("平均值：%.2f\n", average);
        System.out.printf("最大值：%d（索引：%d）\n", max, maxIndex);
        System.out.printf("最小值：%d（索引：%d）\n", min, minIndex);
        System.out.printf("大於平均值的數量：%d\n", countAboveAvg);
        System.out.printf("偶數個數：%d\n", evenCount);
        System.out.printf("奇數個數：%d\n", oddCount);
    }
}

