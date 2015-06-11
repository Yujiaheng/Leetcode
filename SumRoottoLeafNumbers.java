/**
 * Created by JiahengYu on 10/06/15.
 */
public class SumRoottoLeafNumbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result=0;
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;
        manipulation(root,0);
        return result;
    }
    public void manipulation(TreeNode root,int previous){
        int temp=previous*10+root.val;
        if (root.left==null&&root.right==null){
            result+=temp;
            return;
        }
        if (root.left!=null){
            manipulation(root.left,temp);
        }
        if (root.right!=null){
            manipulation(root.right,temp);
        }
    }

    public static void main(String args[]){
        TreeNode test=new TreeNode(0);
        TreeNode test1=new TreeNode(1);
        //TreeNode test2=new TreeNode(3);
        test.left=test1;
        //test.right=test2;
        System.out.print(new SumRoottoLeafNumbers().sumNumbers(test));
    }
}
