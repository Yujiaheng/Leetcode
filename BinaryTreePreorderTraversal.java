import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JiahengYu on 11/06/15.
 */
public class BinaryTreePreorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<Integer>();
        if (root==null)
            return result;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            result.add(temp.val);
            if (temp.right!=null)
                stack.add(temp.right);
            if (temp.left!=null)
                stack.add(temp.left);
        }
        return result;
    }
}
