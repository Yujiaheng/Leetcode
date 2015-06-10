import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by JiahengYu on 09/06/15.
 */
public class BinaryTreeLevelOrderTraversalII {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Tuple{
        TreeNode node;
        int depth;
        public Tuple(TreeNode node,int depth){
            this.node=node;
            this.depth=depth;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if (root==null)
            return result;
        Queue<Tuple> queue=new ConcurrentLinkedQueue<Tuple>();
        Stack<Tuple> stack=new Stack<Tuple>();
        queue.add(new Tuple(root,0));
        while (!queue.isEmpty()){
            Tuple temp=queue.poll();
            stack.push(temp);
            if (temp.node.right!=null) {
                int count=temp.depth+1;
                queue.add(new Tuple(temp.node.right, count));
            }
            if (temp.node.left!=null) {
                int count=temp.depth+1;
                queue.add(new Tuple(temp.node.left, count));
            }
        }
        List<Integer> list=new LinkedList<Integer>();
        int countDepth=stack.peek().depth;
        while (!stack.isEmpty()){
            Tuple temp=stack.pop();
            if (temp.depth==countDepth){
                list.add(temp.node.val);
            }else {
                if (list.size()>0)
                    result.add(list);
                list=new LinkedList<Integer>();
                list.add(temp.node.val);
                countDepth=temp.depth;
            }
        }
        if (list.size()>0)
            result.add(list);
        return result;
    }


    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        List<List<Integer>> result=new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root);
        for (List<Integer> list:result){
            for (Integer data:list){
                System.out.print(data);
            }
            System.out.println();
        }
    }
}
