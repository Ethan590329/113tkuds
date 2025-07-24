import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BSTConversion {

    public static LinkedList<Integer> bstToSortedList(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        inOrderToList(root, result);
        return result;
    }

    private static void inOrderToList(TreeNode node, LinkedList<Integer> list) {
        if (node == null) return;
        inOrderToList(node.left, list);
        list.add(node.val);
        inOrderToList(node.right, list);
    }

    public static TreeNode sortedArrayToBalancedBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBalancedBST(nums, left, mid - 1);
        root.right = buildBalancedBST(nums, mid + 1, right);
        return root;
    }

    public static void convertToGreaterTree(TreeNode root) {
        int[] sum = {0};
        convertReverseInOrder(root, sum);
    }

    private static void convertReverseInOrder(TreeNode node, int[] sum) {
        if (node == null) return;
        convertReverseInOrder(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        convertReverseInOrder(node.left, sum);
    }

    public static void inOrderPrint(TreeNode node) {
        if (node == null) return;
        inOrderPrint(node.left);
        System.out.print(node.val + " ");
        inOrderPrint(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        LinkedList<Integer> sortedList = bstToSortedList(root);
        System.out.println("雙向排序列：" + sortedList);

        int[] sortedArray = sortedList.stream().mapToInt(i -> i).toArray();
        TreeNode balanced = sortedArrayToBalancedBST(sortedArray);
        System.out.print("平衡BST中序：");
        inOrderPrint(balanced);
        System.out.println();

        convertToGreaterTree(root);
        System.out.print("加總轉換後BST：");
        inOrderPrint(root);
        System.out.println();
    }
}
