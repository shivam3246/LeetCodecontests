package sheet.trees;


import java.util.ArrayList;
import java.util.List;

public  class VerticalOrderTraversalBinaryTree {
    public  static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>(); // [col, row, val]
        dfs(root, 0, 0, nodes);

        // Sort by: 1. col ascending -> 2. row ascending -> 3. val ascending
        nodes.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (int[] node : nodes) {
            int col = node[0], val = node[2];
            // Jab column change ho, nayi sub-list start karo
            if (col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = col;
            }
            res.get(res.size() - 1).add(val);
        }

        return res;
    }

    private static void dfs(TreeNode node, int r, int c, List<int[]> nodes) {
        if (node == null) return;
        nodes.add(new int[]{c, r, node.val});
        dfs(node.left, r + 1, c - 1, nodes);
        dfs(node.right, r + 1, c + 1, nodes);
    }
    static void main() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }
}



