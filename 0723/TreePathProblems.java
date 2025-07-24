import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class TreePathProblems {

    public static List<List<Integer>> findAllPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        findPathsHelper(root, new ArrayList<>(), paths);
        return paths;
    }

    private static void findPathsHelper(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        // 是葉節點時加入結果
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            findPathsHelper(node.left, path, result);
            findPathsHelper(node.right, path, result);
        }

        path.remove(path.size() - 1); // 回溯
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }

    public static List<Integer> maxPathSum(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        maxPathHelper(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    private static void maxPathHelper(TreeNode node, List<Integer> path, int sum, int[] maxSum, List<Integer> maxPath) {
        if (node == null) return;

        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                maxPath.clear();
                maxPath.addAll(path);
            }
        } else {
            maxPathHelper(node.left, path, sum, maxSum, maxPath);
            maxPathHelper(node.right, path, sum, maxSum, maxPath);
        }

        path.remove(path.size() - 1); // 回溯
    }

    // 測試程式
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("所有根到葉的路徑:");
        List<List<Integer>> allPaths = findAllPaths(root);
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }

        System.out.println("\n是否存在和為 22 的根到葉路徑: " + hasPathSum(root, 22)); // true

        System.out.println("\n最大總和路徑:");
        System.out.println(maxPathSum(root)); // 應為 [5, 4, 11, 7]
    }
}
