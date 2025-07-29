import java.util.*;

/*
 * Time Complexity: O(n)
 * 說明：使用遞迴 divide & conquer，每一層分半合併，訪問每個元素僅一次；
 *      雖然合併操作有兩層比較，但整體仍為 O(n) 線性時間。
 */

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result[1]);
    }

    static int[] findSecondMax(int[] arr, int left, int right) {
        if (left == right) return new int[]{arr[left], Integer.MIN_VALUE};

        int mid = (left + right) / 2;
        int[] leftPair = findSecondMax(arr, left, mid);
        int[] rightPair = findSecondMax(arr, mid + 1, right);

        int max, second;
        if (leftPair[0] > rightPair[0]) {
            max = leftPair[0];
            second = Math.max(leftPair[1], rightPair[0]);
        } else {
            max = rightPair[0];
            second = Math.max(rightPair[1], leftPair[0]);
        }

        return new int[]{max, second};
    }
}
