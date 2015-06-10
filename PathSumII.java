import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 09/06/15.
 */
public class PathSumII {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if (root==null)
            return result;
        List<Integer>list=new LinkedList<Integer>();
        manipulation(root,list,result,sum);
        return result;
    }
    public void manipulation(TreeNode root, List<Integer>list,List<List<Integer>>result,int sum){
        if (root.left==null&&root.right==null){
            if (sum-root.val==0) {
                list.add(root.val);
                list.add(root.val);
                return;
            }else
                return;
        }
        if (root.left!=null){
            List<Integer> listCopy=new LinkedList<Integer>();
            listCopy.addAll(list);
            listCopy.add(root.val);
            int nextSum=sum-root.val;
            manipulation(root.left,listCopy,result,nextSum);
        }
        if (root.right!=null){
            List<Integer> listCopy=new LinkedList<Integer>();
            listCopy.addAll(list);
            listCopy.add(root.val);
            int nextSum=sum-root.val;
            manipulation(root.right,listCopy,result,nextSum);
        }
    }
}
