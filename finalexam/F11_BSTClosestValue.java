import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        int target = sc.nextInt();
        TreeNode root = buildBST(nodes);
        int closest = findClosest(root, target);
        System.out.println(closest);
    }

    static TreeNode buildBST(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();
            if (!nodes[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i >= nodes.length) break;
            if (!nodes[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    static int findClosest(TreeNode root, int target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target) ||
               (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }
            if (target < root.val) root = root.left;
            else if (target > root.val) root = root.right;
            else break;
        }
        return closest;
    }
}

