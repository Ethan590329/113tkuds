/*
 * Time Complexity: O(n)
 * 說明：每筆資料計算一次電費，總共處理 n 筆輸入。
 */
import java.util.*;

public class Q4_TieredElectricBill {
    public static int calc(int kWh) {
        int bill = 0;

        int[] limits =    {120, 210, 170, 200, 300, Integer.MAX_VALUE};
        double[] prices = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};

        for (int i = 0; i < limits.length; i++) {
            int use = Math.min(kWh, limits[i]);
            bill += Math.round(use * prices[i]);
            kWh -= use;
            if (kWh <= 0) break;
        }

        return bill;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int total = 0;
        int[] bills = new int[n];

        for (int i = 0; i < n; i++) {
            int kWh = Integer.parseInt(sc.nextLine());
            bills[i] = calc(kWh);
            total += bills[i];
        }

        // 印出每筆帳單
        for (int i = 0; i < n; i++) {
            System.out.println("Bill: $" + bills[i]);
        }

        // 印出總費用與平均費用（四捨五入）
        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);

        sc.close();
    }
}

