/**
 * Created by JiahengYu on 19/06/15.
 */
public class CountCompleteTreeNodes {
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
//    public int countNodes(TreeNode root) {
//        int result=0;
//        if (root==null)
//            return result;
//        result=manipulation(root);
//        return result;
//    }
//    private int manipulation(TreeNode root){
//        if (root==null)
//            return 0;
//        if (root.left==null&&root.right==null)
//            return 1;
//        int left=0;
//        int right=0;
//        if (root.left!=null)
//            left=manipulation(root.left);
//        if (root.right!=null)
//            right=manipulation(root.right);
//        return left+right+1;
//    }

    public int countNodes(TreeNode root) {
        if (root==null)
            return 0;
        int leftHeight=0;
        int rightHeight=0;
        //to see if it is full binary tree if it is pow(2*h)-1
        TreeNode move=root;
        while (move!=null){
            leftHeight++;
            move=move.left;
        }
        move=root;
        while (move!=null){
            rightHeight++;
            move=move.right;
        }
        if (leftHeight==rightHeight)
            //return (int)Math.pow(2,leftHeight)-1;
        return (2<<(leftHeight-1))-1;
        else
            return countNodes(root.left)+countNodes(root.right)+1;
    }

    public static void main(String args[]){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(3);
        t1.right = t2;
        t2.left=t3;
        t3.left=t4;
        t3.right=t5;
        System.out.print(new CountCompleteTreeNodes().countNodes(t1));
    }

}
