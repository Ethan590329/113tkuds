import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        TreeNode root = buildTree(tokens);
        List<Integer> leftView = getLeftView(root);
        System.out.print("LeftView:");
        for (int val : leftView) System.out.print(" " + val);
    }

    static TreeNode buildTree(String[] tokens) {
        if (tokens.length == 0 || tokens[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < tokens.length) {
            TreeNode curr = queue.poll();
            if (!tokens[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i >= tokens.length) break;
            if (!tokens[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    static List<Integer> getLeftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return result;
    }
}

