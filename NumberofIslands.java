/**
 * Created by JiahengYu on 16/06/15.
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int count=0;
        if (grid==null||grid.length==0)
            return count;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    count++;
                    manipulation(grid,i,j);
                }
            }
        }
        return count;
    }
    public void manipulation(char[][] grid,int i,int j){
        grid[i][j]='0';
        if (i<grid.length-1){
            if (grid[i+1][j]=='1')
                manipulation(grid,i+1,j);
        }
        if (i>0){
            if (grid[i-1][j]=='1'){
                manipulation(grid,i-1,j);
            }
        }
        if (j>0){
            if (grid[i][j-1]=='1'){
                manipulation(grid,i,j-1);
            }
        }
        if (j<grid[0].length-1){
            if (grid[i][j+1]=='1'){
                manipulation(grid,i,j+1);
            }
        }
    }

    public static void main(String args[]){
        char a[][]={{'1'},{'1'}};
        System.out.println(new NumberofIslands().numIslands(a));
        for (int i=0;i<a.length;i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
