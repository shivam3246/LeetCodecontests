package sheet.trees;

public class MaximumSumBSTinBinaryTree {
    class Pair{
        boolean isBST;
        int min;
        int max;
        int currSum;
        public Pair(boolean isBST,int min,int max,int currSum){
            this.isBST =isBST;
            this.min=min;
            this.max = max;
            this.currSum = currSum;
        }
    }
    int maxSum = 0;
    int maxSumBst(TreeNode root){
        maxSum = 0;
        helper(root);
        return maxSum;
    }
    Pair helper(TreeNode root){
        if(root ==null){
            return new Pair(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        if(left.isBST && right.isBST &&left.max<root.val && right.min>root.val){
            int sum = left.currSum+root.val+right.currSum;
            int min = Math.min(left.min,root.val);
            int max = Math.max(right.max,root.val);
            maxSum = Math.max(maxSum,sum);
            return new Pair(true,min,max,sum);
        }
        return new Pair(false,0,0,0);
    }
    static void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        MaximumSumBSTinBinaryTree ms = new MaximumSumBSTinBinaryTree();
        int sum = ms.maxSumBst(root);
        System.out.println(sum);
    }
}
