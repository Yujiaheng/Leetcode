/**
 * Created by JiahengYu on 09/06/15.
 */
public class ConvertSortedArrayBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0)
            return null;
        else
            return manipulation(0,nums.length-1,nums);

    }
    public TreeNode manipulation(int start,int end,int []nums){
        if (start>end)
            return null;
        if (start==end)
            return new TreeNode(nums[start]);
        int mid=(start+end)/2;
        TreeNode thisNode=new TreeNode(nums[mid]);
        thisNode.left=manipulation(start,mid-1,nums);
        thisNode.right=manipulation(mid+1,end,nums);
        return thisNode;
    }



    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        TreeNode test=new ConvertSortedArrayBinarySearchTree().sortedArrayToBST(a);
    }
}
