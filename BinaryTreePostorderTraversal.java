import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JiahengYu on 11/06/15.
 */
public class BinaryTreePostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Tuple{
        TreeNode node;
        int count;
        public Tuple(TreeNode node,int count){
            this.node=node;
            this.count=count;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<Integer>();
        if (root==null)
            return result;
        Stack<Tuple> stack=new Stack<Tuple>();
        stack.add(new Tuple(root,0));
        while (!stack.isEmpty()){
            Tuple temp=stack.pop();
            if (temp.count==2)
                result.add(temp.node.val);
            else if (temp.count==0){
                stack.push(new Tuple(temp.node,temp.count+1));
                if (temp.node.right!=null)
                stack.push(new Tuple(temp.node.right,0));
            }else if (temp.count==1){
                stack.push(new Tuple(temp.node,temp.count+1));
                if (temp.node.left!=null)
                    stack.push(new Tuple(temp.node.left,0));
            }
        }
        return result;
    }
}
