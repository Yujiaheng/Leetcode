import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 19/06/15.
 */
public class UniqueBinarySearchTreesII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//    public List<TreeNode> generateTrees(int n) {
//        return generateTree(1, n);
//    }
//    private List<TreeNode> generateTree(int m,int n){
//        if (m>n){
//            List<TreeNode> ressult=new ArrayList<TreeNode>();
//            ressult.add(null);
//            return ressult;
//        }
//        List<TreeNode>roots=new ArrayList<TreeNode>();
//        for (int i=m;i<=n;i++){
//            List<TreeNode> left=generateTree(m, i - 1);
//            List<TreeNode> right=generateTree(i + 1, n);
//            for (TreeNode l:left){
//                for (TreeNode r:right){
//                    TreeNode root=new TreeNode(i);
//                    root.left=l;
//                    root.right=r;
//                    roots.add(root);
//                }
//            }
//        }
//        return roots;
//    }

    /**
     * 应该说 形状差不多 只是  值需要改变  所以 用dp算法貌似不好办
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            List<TreeNode> here = new LinkedList<TreeNode>();
            here.add(null);
            return here;
        }
        List<TreeNode> result = new LinkedList<TreeNode>();
        List<TreeNode> dp[] = new LinkedList[n + 1];
        dp[0] = new LinkedList<TreeNode>();
        dp[0].add(null);
        dp[1] = new LinkedList<TreeNode>();
        dp[1].add(new TreeNode(1));
        if (n == 1)
            return dp[1];
        dp[2] = new LinkedList<TreeNode>();
        TreeNode one = new TreeNode(1);
        one.right = new TreeNode(2);
        dp[2].add(one);
        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(1);
        dp[2].add(two);
        if (n == 2)
            return dp[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = new LinkedList<TreeNode>();
            for (int j = 0; j < i; j++) {
                TreeNode temp = new TreeNode(j + 1);
                for (TreeNode left : dp[j]) {
                    for (TreeNode right : dp[i - j - 1]) {
                        temp.left = left;
                        temp.right = right;
                        dp[i].add(temp);
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String args[]){
        new UniqueBinarySearchTreesII().generateTrees(3);
    }
}
