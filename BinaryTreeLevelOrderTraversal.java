import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by JiahengYu on 08/06/15.
 */
public class BinaryTreeLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if (root==null)
            return result;
        Queue<TreeNode> one=new ConcurrentLinkedQueue<TreeNode>();
        Queue<TreeNode> two=new ConcurrentLinkedQueue<TreeNode>();
        one.add(root);
        while (!one.isEmpty()||!two.isEmpty()){
            List<Integer> temp1=new LinkedList<Integer>();
            while (!one.isEmpty()){
                TreeNode temp=one.poll();
                temp1.add(temp.val);
                if(temp.left!=null)
                    two.add(temp.left);
                if(temp.right!=null)
                    two.add(temp.right);
            }
            if(temp1.size()>0)
                result.add(temp1);
            List<Integer> temp2=new LinkedList<Integer>();
            while (!two.isEmpty()){
                TreeNode temp=two.poll();
                temp2.add(temp.val);
                if(temp.left!=null)
                    one.add(temp.left);
                if(temp.right!=null)
                    one.add(temp.right);
            }
            if(temp2.size()>0)
                result.add(temp2);
        }
        return result;
    }
}
