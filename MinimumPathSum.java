/**
 * Created by JiahengYu on 04/06/15.
 */
public class MinimumPathSum{
    public int minPathSum(int[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int dp[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++){
            if (i==0)
                dp[i][0]=grid[i][0];
            else
                dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for (int i=0;i<dp[0].length;i++){
            if (i==0)
                dp[0][i]=grid[0][i];
            else
                dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
