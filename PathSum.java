/**
 * Created by JiahengYu on 09/06/15.
 */
public class PathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        return manipulation(root,sum);
    }
    public boolean manipulation(TreeNode root,int sum) {
        if (root==null)
            return false;
        if (root.left==null&&root.right==null){
            if (sum-root.val==0)
                return true;
            else
                return false;
        }else
            return manipulation(root.left,sum-root.val)||manipulation(root.right,sum-root.val);
    }
}
