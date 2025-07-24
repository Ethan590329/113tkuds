import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BSTBalance {

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        if (left == -1) return -1;
        int right = checkHeight(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static TreeNode findMostUnbalanced(TreeNode root) {
        TreeNode[] result = new TreeNode[1];
        int[] maxDiff = {0};
        findUnbalancedHelper(root, result, maxDiff);
        return result[0];
    }

    private static int findUnbalancedHelper(TreeNode node, TreeNode[] result, int[] maxDiff) {
        if (node == null) return 0;
        int left = findUnbalancedHelper(node.left, result, maxDiff);
        int right = findUnbalancedHelper(node.right, result, maxDiff);
        int diff = Math.abs(left - right);
        if (diff > maxDiff[0]) {
            maxDiff[0] = diff;
            result[0] = node;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        System.out.println(isBalanced(root));
        System.out.println(getBalanceFactor(root.left));
        TreeNode unbalanced = findMostUnbalanced(root);
        System.out.println(unbalanced.val);
    }
}
