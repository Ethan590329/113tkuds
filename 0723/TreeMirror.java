class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class TreeMirror {

    // 1. 判斷是否為對稱樹（左右為鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 2. 將樹轉換為其鏡像（就地轉換）
    public static void mirror(TreeNode root) {
        if (root == null) return;
        // 先處理左右子樹
        mirror(root.left);
        mirror(root.right);
        // 然後交換
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // 3. 判斷兩棵樹是否互為鏡像
    public static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.val == b.val) &&
               isMirror(a.left, b.right) &&
               isMirror(a.right, b.left);
    }

    // 測試用主程式
    public static void main(String[] args) {
        // 建立一棵對稱樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("是否為對稱樹: " + isSymmetric(root)); // true

        // 測試鏡像轉換
        mirror(root);
        System.out.println("鏡像後是否仍為對稱: " + isSymmetric(root)); // true（剛好又對稱）

        // 測試是否為互為鏡像
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(3);
        b.right = new TreeNode(2);

        System.out.println("a 和 b 是否互為鏡像: " + isMirror(a, b)); // true
    }
}
