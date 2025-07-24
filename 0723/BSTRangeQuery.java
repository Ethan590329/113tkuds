import java.util.ArrayList;
import java.util.Collections;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BSTRangeQuery {

    // 插入節點到BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // 主方法：回傳指定區間[min, max]內的節點值（排序好的 ArrayList）
    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRange(root, min, max, result);
        return result;
    }

    // 遞迴中序搜尋並收集範圍內節點
    private static void inOrderRange(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        // 左子樹遞迴（若節點值大於 min）
        if (node.val > min) {
            inOrderRange(node.left, min, max, result);
        }

        // 加入符合區間的節點
        if (node.val >= min && node.val <= max) {
            result.add(node.val);
        }

        // 右子樹遞迴（若節點值小於 max）
        if (node.val < max) {
            inOrderRange(node.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        // 建立 BST
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        // 範圍查詢 [12, 27]
        ArrayList<Integer> result = rangeQuery(root, 12, 27);
        System.out.println("查詢結果：" + result);  // 應輸出 [15, 20, 25]
    }
}
