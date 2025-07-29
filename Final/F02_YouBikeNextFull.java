import java.util.*;

/*
 * Time Complexity: O(n)
 * 說明：最多需掃描一次 n 筆補車時間進行查詢，轉換與比較時間皆為 O(1)，
 *      故整體複雜度為 O(n)。
 */

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            times.add(toMinutes(time));
        }

        int query = toMinutes(sc.nextLine());

        int result = -1;
        for (int time : times) {
            if (time >= query) {
                result = time;
                break;
            }
        }

        if (result == -1) {
            System.out.println("No bike");
        } else {
            System.out.printf("%02d:%02d\n", result / 60, result % 60);
        }
    }

    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
