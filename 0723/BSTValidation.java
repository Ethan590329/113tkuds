import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BSTValidation {

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return isValidBSTHelper(node.left, min, node.val) &&
               isValidBSTHelper(node.right, node.val, max);
    }

    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> invalidNodes = new ArrayList<>();
        findInvalidNodesHelper(root, Long.MIN_VALUE, Long.MAX_VALUE, invalidNodes);
        return invalidNodes;
    }

    private static void findInvalidNodesHelper(TreeNode node, long min, long max, List<TreeNode> list) {
        if (node == null) return;

        if (node.val <= min || node.val >= max) {
            list.add(node);
        }

        findInvalidNodesHelper(node.left, min, node.val, list);
        findInvalidNodesHelper(node.right, node.val, max, list);
    }

    // 策略：中序遍歷後找出最長遞增子序列（Longest Increasing Subsequence）
    public static int minNodesToRemove(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);

        int lis = longestIncreasingSubsequence(inorder);
        return inorder.size() - lis;
    }

    private static void getInOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        getInOrder(node.left, list);
        list.add(node.val);
        getInOrder(node.right, list);
    }

    // 動態規劃求 LIS（可改用 binary search 降低到 O(n log n)）
    private static int longestIncreasingSubsequence(List<Integer> nums) {
        if (nums.isEmpty()) return 0;
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }

    // 主測試方法
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        System.out.println("是否為有效 BST: " + isValidBST(root)); // false

        System.out.println(" 違規節點：");
        for (TreeNode n : findInvalidNodes(root)) {
            System.out.println("節點值: " + n.val);
        }

        System.out.println("最少需移除節點數: " + minNodesToRemove(root)); // 輸出違規節點數量（可能為1）
    }
}
