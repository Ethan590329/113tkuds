class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int val) {
        this.value = val;
        this.left = this.right = null;
    }
}

public class TreeStatistics {

    // 1. 計算所有節點值的總和
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.value + sum(root.left) + sum(root.right);
    }

    // 2. 找最大值
    public static int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.value, Math.max(leftMax, rightMax));
    }

    // 2. 找最小值
    public static int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        return Math.min(root.value, Math.min(leftMin, rightMin));
    }

    // 3. 計算葉節點數量
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 4. 計算樹的深度（高度）
    public static int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // 測試用範例樹
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(30);

        System.out.println("總和: " + sum(root));
        System.out.println("最大值: " + findMax(root));
        System.out.println("最小值: " + findMin(root));
        System.out.println("葉節點數量: " + countLeaves(root));
        System.out.println("樹的高度: " + height(root));
    }
}
