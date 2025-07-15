import java.util.*;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入站數
        int n = Integer.parseInt(sc.nextLine());

        // 讀入站名
        String[] stations = sc.nextLine().split(" ");

        // 讀入起點與終點
        String start = sc.next();
        String end = sc.next();

        // 找出起點與終點的索引
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) {
                startIndex = i;
            }
            if (stations[i].equals(end)) {
                endIndex = i;
            }
        }

        // 輸出結果
        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(endIndex - startIndex) + 1);
        }

        sc.close();
    }
}

