package sheet.trees;

public class LCATrees {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p||root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null &&right!=null){
            return root;
        }
        return left==null?right:left;
    }
    static void main() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        TreeNode p = root.left;
        TreeNode q = root.right;
        LCATrees lc = new LCATrees();
        TreeNode ans = lc.lowestCommonAncestor(root,p,q);
        System.out.println(ans.val);
//        PrintTree pp = new PrintTree();
//        pp.print(ans);

    }
}
