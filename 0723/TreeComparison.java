class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class TreeComparison {

    public static boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode sub) {
        if (sub == null) return true;
        if (root == null) return false;
        if (isIdentical(root, sub)) return true;
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);
        b.left.left = new TreeNode(4);
        b.left.right = new TreeNode(5);

        TreeNode sub = new TreeNode(2);
        sub.left = new TreeNode(4);
        sub.right = new TreeNode(5);

        System.out.println(isIdentical(a, b));
        System.out.println(isSubtree(a, sub));

        TreeNode p = a.left.left;
        TreeNode q = a.left.right;
        TreeNode lca = lowestCommonAncestor(a, p, q);
        System.out.println(lca.val);
    }
}
