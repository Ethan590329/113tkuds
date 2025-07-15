import java.util.*;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入資料筆數
        int n = Integer.parseInt(sc.nextLine());
        double[] scores = new double[n];

        // 讀入評分
        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(sc.nextLine());
        }

        // Selection Sort 選擇排序（從大到小）
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 交換
            double temp = scores[i];
            scores[i] = scores[maxIndex];
            scores[maxIndex] = temp;
        }

        // 輸出前 5 名（或全部）
        int outputCount = Math.min(5, n);
        for (int i = 0; i < outputCount; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }

        sc.close();
    }
}

