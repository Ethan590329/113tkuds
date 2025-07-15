import java.util.*;

public class Q2_NextTHSRDeparture {
    // 時間轉分鐘
    public static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入班次數量
        int n = Integer.parseInt(sc.nextLine());

        // 儲存原始時間與分鐘
        String[] originalTimes = new String[n];
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            originalTimes[i] = sc.nextLine();
            minutes[i] = toMinutes(originalTimes[i]);
        }

        // 讀入查詢時間並轉換成分鐘
        String query = sc.nextLine();
        int queryMin = toMinutes(query);

        // Binary search 找第一個大於 queryMin 的時間
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (minutes[i] > queryMin) {
                idx = i;
                break;
            }
        }

        // 輸出
        if (idx == -1) {
            System.out.println("No train");
        } else {
            System.out.println(originalTimes[idx]);
        }

        sc.close();
    }
}

