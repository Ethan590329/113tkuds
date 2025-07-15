import java.util.*;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入資料筆數
        int n = Integer.parseInt(sc.nextLine());

        String[] station = new String[n];
        int[][] price = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\|");
            station[i] = parts[0];
            price[i][0] = Integer.parseInt(parts[1]); // 標準
            price[i][1] = Integer.parseInt(parts[2]); // 商務
        }

        // 印出表頭
        System.out.println("Station|Standard|Business");

        // 印出每一列
        for (int i = 0; i < n; i++) {
            System.out.printf("%s|%d|%d\n", station[i], price[i][0], price[i][1]);
        }

        sc.close();
    }
}

