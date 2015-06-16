/**
 * Created by JiahengYu on 15/06/15.
 */
public class InvertBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
        if (root==null)
            return null;
        if (root.left==null&&root.right==null)
            return root;
        manipulation(root);
        return root;
    }
    private void manipulation(TreeNode root) {
        if (root==null)
            return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        TreeNode temp=left;
        root.left=right;
        root.right=temp;
        manipulation(root.left);
        manipulation(root.right);
    }

}
