import java.util.*;

public class Q10_ArrayToStringUtil {
    // 靜態方法：模仿 Arrays.toString
    public static String arrayToString(int[] arr) {
        if (arr == null) return "null";
        if (arr.length == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // 主程式入口
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入陣列長度
        int n = Integer.parseInt(sc.nextLine());

        // 若 n 為 0，傳入空陣列
        int[] data = (n == 0) ? new int[0] : new int[n];

        if (n > 0) {
            String[] tokens = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(tokens[i]);
            }
        }

        // 輸出陣列字串
        System.out.println(arrayToString(data));

        sc.close();
    }
}

