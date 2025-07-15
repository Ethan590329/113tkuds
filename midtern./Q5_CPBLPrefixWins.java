import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入比賽場數
        int n = Integer.parseInt(sc.nextLine());

        // 讀入比賽結果
        String[] tokens = sc.nextLine().split(" ");
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }

        // 讀入要查詢前 k 場
        int k = Integer.parseInt(sc.nextLine());

        // 計算 prefix sum
        int[] ps = new int[n + 1]; // ps[0] = 0 預留，ps[i] 表示前 i 場累積勝場數
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + result[i - 1];
        }

        // 輸出前 k 場 prefix sum（從 ps[1] 到 ps[k]）
        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();

        sc.close();
    }
}

