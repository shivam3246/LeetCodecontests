package sheet.trees;

public class BinaryMaximumPathSum {
    int ans = 0;
    public int maxPathSum(TreeNode root){
        helper(root);
        return ans;
    }
    int helper(TreeNode node){
        if(node==null)
            return 0;
        int left=helper(node.left);
        left =Math.max(0,left);
        int right = helper(node.right);
        right = Math.max(0,right);
        int pathSum = left+right+node.val;
        ans = Math.max(pathSum,ans);
        return Math.max(left,right)+node.val;
   }

    static void main() {
        TreeNode root = new TreeNode(-10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        BinaryMaximumPathSum bd = new BinaryMaximumPathSum();
        int ans = bd.maxPathSum(root);
        System.out.println(ans);

    }
}
