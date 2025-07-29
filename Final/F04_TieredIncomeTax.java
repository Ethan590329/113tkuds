import java.util.*;

/*
 * Time Complexity: O(n)
 * 說明：每筆收入只需依據五級距依序計算稅額，固定次數操作為 O(1)，
 *      n 筆資料共需 O(n) 時間處理，總體為線性時間。
 */

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double[] taxes = new double[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            int income = Integer.parseInt(sc.nextLine());
            double tax = calculateTax(income);
            taxes[i] = tax;
            total += tax;
        }

        for (double tax : taxes) {
            System.out.printf("Tax: $%.1f\n", tax);
        }

        double avg = total / n;
        System.out.printf("Average: $%.1f\n", avg);
    }

    static double calculateTax(int income) {
        int[] brackets = {540_000, 1_210_000, 2_420_000, 4_530_000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};
        double tax = 0;
        int previous = 0;

        for (int i = 0; i < brackets.length; i++) {
            if (income <= brackets[i]) {
                tax += (income - previous) * rates[i];
                return tax;
            } else {
                tax += (brackets[i] - previous) * rates[i];
                previous = brackets[i];
            }
        }

        tax += (income - previous) * rates[4];
        return tax;
    }
}
