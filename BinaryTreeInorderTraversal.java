import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JiahengYu on 08/06/15.
 */
public class BinaryTreeInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result=new LinkedList<Integer>();
        manipulation2(root, result);
        return result;
    }
    public void manipulation(TreeNode root,List<Integer> result){
        if (root==null)
            return;
        manipulation(root.left, result);
        result.add(root.val);
        manipulation(root.right,result);
    }
    class Tuple{
        TreeNode node;
        int count;
        public Tuple(TreeNode node,int count){
            this.count=count;
            this.node=node;
        }
    }
    public void manipulation2(TreeNode root,List<Integer>result){
        if (root==null)
            return;
        Stack<Tuple> stack=new Stack<Tuple>();
        Tuple first=new Tuple(root,0);
        stack.push(first);
        while (!stack.isEmpty()){
            Tuple temp=stack.pop();
            if (temp.count==1)
                result.add(temp.node.val);
            else {
                if (temp.node.right!=null){
                    stack.push(new Tuple(temp.node.right,0));
                }
                temp.count=1;
                stack.push(temp);
                if (temp.node.left!=null){
                    stack.push(new Tuple(temp.node.left,0));
                }
            }
        }
    }


    public static void main(String args[]){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.right = t2;
        t2.left=t3;
        List<Integer> result=new BinaryTreeInorderTraversal().inorderTraversal(t1);
        for (Integer a:result){
            System.out.print(a);
        }
    }
}
