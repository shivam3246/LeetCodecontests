package sheet.trees;

public class DiameterOfABinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;        }
    }
    int diameter =0;
    int diameterOfABinaryTree(TreeNode root){
        helper(root);
        return diameter;
    }
    int helper(TreeNode root){
        if(root ==null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int di = left +right;
        diameter = Math.max(di,diameter);
        return Math.max(left,right)+1;
    }
    void print(TreeNode root){
        if(root==null)
            return;
        print(root.left);
        System.out.print(root.val+" ");
        print(root.right);
    }
    static void main() {
        DiameterOfABinaryTree d = new DiameterOfABinaryTree();
        TreeNode root = d.new TreeNode(1);
        root.left = d.new TreeNode(2);
        root.right = d.new TreeNode(3);
        root.left.left = d.new TreeNode(4);
        root.left.right = d.new TreeNode(5);
        d.print(root);
        int ans = d.diameterOfABinaryTree(root);
        System.out.println("\n\n\n\n");
        System.out.println(ans);
    }
}
