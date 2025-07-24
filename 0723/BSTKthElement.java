class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BSTKthElement {

    // 用來追蹤第幾個元素
    static int count = 0;
    static int result = -1;

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inOrder(root, k);
        return result;
    }

    private static void inOrder(TreeNode node, int k) {
        if (node == null || count >= k) return;

        // 左
        inOrder(node.left, k);

        // 根
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // 右
        inOrder(node.right, k);
    }

    // 插入節點到 BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // 主測試方法
    public static void main(String[] args) {
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        int k = 3;
        System.out.println("BST 第 " + k + " 小的元素是: " + kthSmallest(root, k)); // 應輸出 15
    }
}
