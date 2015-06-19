import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by JiahengYu on 19/06/15.
 */
public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Tuple{
        TreeNode node;
        int count=0;
        public Tuple(TreeNode node,int count){
            this.count=count;
            this.node=node;
        }
    }
    Stack<Tuple> stack;
    Queue<Integer> queue;
    TreeNode root;
    public BSTIterator(TreeNode root) {
//        stack=new Stack<Tuple>();
        queue=new ConcurrentLinkedQueue<Integer>();
//        this.root=root;
//        if (root!=null) {
//            stack.push(new Tuple(root, 0));
//            while (!stack.isEmpty()) {
//                Tuple temp = stack.pop();
//                if (temp.count == 1)
//                    queue.add(temp.node);
//                else {
//                    if (temp.node.right != null) {
//                        stack.push(new Tuple(temp.node.right, 0));
//                    }
//                    temp.count++;
//                    stack.push(temp);
//                    if (temp.node.left != null) {
//                        stack.push(new Tuple(temp.node.left, 0));
//                    }
//                }
//            }
//        }
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        if(root.left != null) inorder(root.left);
        queue.add(root.val);
        if(root.right != null) inorder(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (queue.size()!=0){
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        int result=0;
        if (queue.size()!=0){
            result=queue.poll();
        }
        return result;
    }
}
