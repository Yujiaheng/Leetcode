/**
 * Created by JiahengYu on 08/06/15.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            for (int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        System.out.print(new UniqueBinarySearchTrees().numTrees(5));
    }
}
