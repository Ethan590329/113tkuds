import java.util.*;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 初始化 10x10 地圖（先填 #）
        char[][] map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(map[i], '#');
        }

        // 讀入座標數
        int m = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split(" ");
            int r = Integer.parseInt(parts[0]);
            int c = Integer.parseInt(parts[1]);

            // 確認座標合法（0~9）
            if (r >= 0 && r < 10 && c >= 0 && c < 10) {
                map[r][c] = '*';
            }
        }

        // 輸出地圖
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}

