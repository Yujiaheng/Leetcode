/**
 * Created by JiahengYu on 09/06/15.
 */
public class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        if (maxDepth(root)-minDepth(root)<=1)
            return true;
        else return false;
    }
    public int maxDepth(TreeNode root){
        if (root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public int minDepth(TreeNode root){
        if (root==null)
            return 0;
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
    public static void main(String args[]){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.right=t2;
        t2.right=t3;
        System.out.print(new BalancedBinaryTree());
    }
}
