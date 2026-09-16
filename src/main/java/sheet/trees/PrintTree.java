package sheet.trees;

public class PrintTree {
    void print(TreeNode root){
        if(root==null)
            return;
        print(root.left);
        System.out.print(root.val+" => ");
        print(root.right);
    }
}
