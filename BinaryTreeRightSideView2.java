import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by JiahengYu on 16/06/15.
 */
public class BinaryTreeRightSideView2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
        if (root==null)
            return list;
        Queue<TreeNode> one = new ConcurrentLinkedQueue<TreeNode>();
        Queue<TreeNode> two = new ConcurrentLinkedQueue<TreeNode>();
        one.add(root);
        while (!one.isEmpty()||!two.isEmpty()){
            int i=0;
            while (!one.isEmpty()){
                TreeNode temp=one.poll();
                if (i==0) {
                    list.add(temp.val);
                }
                if (temp.right!=null) {
                    two.add(temp.right);
                }
                if (temp.left!=null){
                    two.add(temp.left);
                }
                i++;
            }
            i=0;
            while (!two.isEmpty()){
                TreeNode temp=two.poll();
                if (i==0) {
                    list.add(temp.val);
                }
                if (temp.right!=null) {
                    one.add(temp.right);
                }
                if (temp.left!=null){
                    one.add(temp.left);
                }
                i++;
            }
        }
        return list;
    }

    public static void main(String args[]){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
//        TreeNode t3=new TreeNode(3);
//        TreeNode t4=new TreeNode(4);
//        TreeNode t5=new TreeNode(5);
        t1.left=t2;
//        t1.right=t3;
//        t2.right=t5;
//        t3.right=t4;
        List<Integer> result=new BinaryTreeRightSideView2().rightSideView(t1);
        for (int a:result){
            System.out.print(a);
        }
    }
}
