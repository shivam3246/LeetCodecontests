package sheet.trees;

public class BalancedBinaryTree {


    public  boolean isBalanced(TreeNode root){
        return helper(root)!=-1;
    }
    int helper(TreeNode root){
        if(root ==null)
            return 0;
        int left = helper(root.left);
        if(left==-1)
            return -1;//left subtree is not balanced
        int right = helper(root.right);
        if(right==-1)
            return -1;//Right Subtree is not balanced
        if(Math.abs(left-right)>1)
            return -1;//Current node is not balanced
        return 1+Math.max(left,right);
    }
    static void main() {
        BalancedBinaryTree bd = new BalancedBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        PrintTree p = new PrintTree();
        p.print(root);
        System.out.println("\n\n\n");
        System.out.println(bd.isBalanced(root));

    }
}
