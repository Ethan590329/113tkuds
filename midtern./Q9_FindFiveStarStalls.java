import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入攤位數量
        int n = Integer.parseInt(sc.nextLine());

        // 讀入分數
        String[] tokens = sc.nextLine().split(" ");
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(tokens[i]);
        }

        // 搜尋分數為 5.0 的索引
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5.0) {
                indexList.add(i);
            }
        }

        // 輸出結果
        if (indexList.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < indexList.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(indexList.get(i));
            }
            System.out.println();
        }

        sc.close();
    }
}

