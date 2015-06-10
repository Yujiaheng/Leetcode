/**
 * Created by JiahengYu on 05/06/15.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return;
        int row[]=new int[matrix.length];
        int column[]=new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    row[i]=1;
                    column[j]=1;
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            if (row[i]==1){
                for (int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for (int i=0;i<matrix[0].length;i++){
            if (column[i]==1){
                for (int j=0;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
    }
}
