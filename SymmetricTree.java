/**
 * Created by JiahengYu on 08/06/15.
 */
public class SymmetricTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        if (root.left==null&&root.right==null)
            return true;
        if (root.left==null||root.right==null)
            return false;
        boolean result=manipulation(root.left,root.right);
        return result;
    }
    public boolean manipulation(TreeNode one,TreeNode two){
        if (one==null&&two==null)
            return true;
        if (one==null||two==null)
            return false;
        if (one.val!=two.val)
            return false;
        else {
            return manipulation(one.left,two.right)&&manipulation(one.right,two.left);
        }
    }
}
