import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class TreeReconstruction {

    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildPreIn(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) return null;

        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inL;
        while (inorder[rootIdx] != rootVal) rootIdx++;
        int leftSize = rootIdx - inL;

        root.left = buildPreIn(preorder, preL + 1, preL + leftSize, inorder, inL, rootIdx - 1);
        root.right = buildPreIn(preorder, preL + leftSize + 1, preR, inorder, rootIdx + 1, inR);
        return root;
    }

    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildPostIn(int[] postorder, int postL, int postR, int[] inorder, int inL, int inR) {
        if (postL > postR || inL > inR) return null;

        int rootVal = postorder[postR];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inL;
        while (inorder[rootIdx] != rootVal) rootIdx++;
        int leftSize = rootIdx - inL;

        root.left = buildPostIn(postorder, postL, postL + leftSize - 1, inorder, inL, rootIdx - 1);
        root.right = buildPostIn(postorder, postL + leftSize, postR - 1, inorder, rootIdx + 1, inR);
        return root;
    }

    public static boolean validateTree(TreeNode root, int[] preorder, int[] inorder) {
        List<Integer> actualPre = new ArrayList<>();
        List<Integer> actualIn = new ArrayList<>();
        getPreorder(root, actualPre);
        getInorder(root, actualIn);

        return Arrays.equals(actualPre.stream().mapToInt(i -> i).toArray(), preorder) &&
               Arrays.equals(actualIn.stream().mapToInt(i -> i).toArray(), inorder);
    }

    private static void getPreorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        getPreorder(node.left, list);
        getPreorder(node.right, list);
    }

    private static void getInorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        getInorder(node.left, list);
        list.add(node.val);
        getInorder(node.right, list);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode treeFromPreIn = buildFromPreIn(preorder, inorder);
        TreeNode treeFromPostIn = buildFromPostIn(postorder, inorder);

        System.out.println(validateTree(treeFromPreIn, preorder, inorder)); // true
        System.out.println(validateTree(treeFromPostIn, preorder, inorder)); // true
    }
}
