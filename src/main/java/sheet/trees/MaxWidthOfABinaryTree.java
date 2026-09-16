package sheet.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfABinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Node{
        TreeNode node;
        int idx;
        public Node(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
int maxWidth(TreeNode root){
        Queue<Node> q= new LinkedList<>();
        q.add(new Node(root,0));
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0;i<size;i++){
                Node temp = q.poll();
                int idx = temp.idx;
                if(i==0)
                    start = idx;
                if(i == size-1)
                    end = idx;
                if(temp.node.left!=null)
                    q.add(new Node(temp.node.left,2*temp.idx));
                if(temp.node.right!=null)
                    q.add(new Node(temp.node.right,2*temp.idx+1));
            }
            max = Math.max(max,end-start+1);
        }
        return max;
}
void print(TreeNode root){
        if(root==null)
            return;
    System.out.print(root.val +" => ");
    print(root.left);
    print(root.right);
}
    static void main() {
        MaxWidthOfABinaryTree mw = new MaxWidthOfABinaryTree();
        TreeNode root = mw.new TreeNode(1);
        root.left=mw.new TreeNode(3);
        root.right=mw.new TreeNode(2);
        root.left.left = mw.new TreeNode(5);
        root.left.right = mw.new TreeNode(3);
        root.right.right=mw.new TreeNode(3);
        mw.print(root);
        int max = mw.maxWidth(root);
        System.out.println("\n\n");
        System.out.println(max);
    }
}
