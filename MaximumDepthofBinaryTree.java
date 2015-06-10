import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by JiahengYu on 08/06/15.
 */
public class MaximumDepthofBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * recursion will exceed the time limit
     */
//    public int maxDepth(TreeNode root) {
//        if (root==null)
//            return 0;
//        int left=manipulation(root.left);
//        int right=manipulation(root.right);
//        return left>right?left:right;
//    }
//    public int manipulation(TreeNode root){
//        if (root==null)
//            return 0;
//        return 1+(manipulation(root.left)>manipulation(root.right)?manipulation(root.left):manipulation(root.right));
//    }

    class Tuple{
        TreeNode node;
        int count;
        public Tuple(TreeNode node, int count){
            this.count=count;
            this.node=node;
        }
    }


    public int maxDepth(TreeNode root) {
        int maxLength=0;
        if (root==null)
            return maxLength;
        Stack<Tuple> stack=new Stack<Tuple>();
        stack.push(new Tuple(root,1));
        while(!stack.isEmpty()){
            Tuple temp=stack.pop();
            TreeNode node=temp.node;
            if (node.left==null&&node.right==null)
                maxLength=maxLength>temp.count?maxLength:temp.count;
            if (node.left!=null){
                int count=temp.count+1;
                stack.push(new Tuple(node.left,count));
            }
            if (node.right!=null){
                int count=temp.count+1;
                stack.push(new Tuple(node.right,count));
            }
        }
        return maxLength;
    }

}
