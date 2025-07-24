import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class TreeDistance {

    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static int distance(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findLCA(root, p, q);
        return pathLength(lca, p, 0) + pathLength(lca, q, 0);
    }

    private static int pathLength(TreeNode root, TreeNode target, int depth) {
        if (root == null) return -1;
        if (root == target) return depth;
        int left = pathLength(root.left, target, depth + 1);
        if (left != -1) return left;
        return pathLength(root.right, target, depth + 1);
    }

    public static int treeDiameter(TreeNode root) {
        int[] max = {0};
        depth(root, max);
        return max[0];
    }

    private static int depth(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = depth(node.left, max);
        int right = depth(node.right, max);
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
    }

    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        collectNodesAtDistanceK(root, k, result);
        return result;
    }

    private static void collectNodesAtDistanceK(TreeNode node, int k, List<Integer> result) {
        if (node == null) return;
        if (k == 0) {
            result.add(node.val);
            return;
        }
        collectNodesAtDistanceK(node.left, k - 1, result);
        collectNodesAtDistanceK(node.right, k - 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeNode p = root.left.left;
        TreeNode q = root.right.right;

        System.out.println(distance(root, p, q));
        System.out.println(treeDiameter(root));
        System.out.println(nodesAtDistanceK(root, 2));
    }
}
