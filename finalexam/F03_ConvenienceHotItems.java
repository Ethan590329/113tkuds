import java.util.*;

/*
 * Time Complexity: O(n^2)
 * 說明：採用插入排序，最壞情況下需進行約 n² 次比較與搬移，
 *      輸出前十名為 O(1)，總體主體複雜度為 O(n^2)。
 */

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] names = new String[n];
        int[] qtys = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            names[i] = parts[0];
            qtys[i] = Integer.parseInt(parts[1]);
        }

        for (int i = 1; i < n; i++) {
            String tempName = names[i];
            int tempQty = qtys[i];
            int j = i - 1;
            while (j >= 0 && qtys[j] < tempQty) {
                names[j + 1] = names[j];
                qtys[j + 1] = qtys[j];
                j--;
            }
            names[j + 1] = tempName;
            qtys[j + 1] = tempQty;
        }

        for (int i = 0; i < Math.min(10, n); i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
    }
}
