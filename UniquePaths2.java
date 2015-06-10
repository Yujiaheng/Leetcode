/**
 * Created by JiahengYu on 04/06/15.
 */
public class UniquePaths2 {
    public static int result=0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0)
            return 0;
        manipulation(0,0,obstacleGrid);
        return  result;
    }
    public void manipulation(int currentRow,int currentColumn,int [][]obstacle){
        if (currentRow==obstacle.length-1&&currentColumn==obstacle[0].length-1){
            result++;
            return;
        }
        if (currentRow<obstacle.length-1){
            if (obstacle[currentRow + 1][currentColumn] != 1) {
                manipulation(currentRow + 1, currentColumn, obstacle);
            }
        }
        if (currentColumn<obstacle[0].length-1){
            if (obstacle[currentRow][currentColumn + 1] != 1) {
                manipulation(currentRow, currentColumn + 1, obstacle);
            }
        }
    }
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = 1;
            else
                break;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else
                break;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }


    public static void main(String args[]){
        int obstacle[][]={{0,1},{0,0}};
        System.out.println(new UniquePaths2().uniquePathsWithObstacles2(obstacle));
    }
}
