import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 02/06/15.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new LinkedList<Integer>();
        if (matrix==null||matrix.length==0)return list;
        manipulation(matrix,0,matrix.length-1,0,matrix[0].length-1,list);
        return list;
    }
    public void manipulation(int [][]matrix,int startRow, int endRow,int startColumn,int endColumn, List<Integer>list){
        if (startRow>endRow||startColumn>endColumn) {
            return;
        }
        if (startRow==endRow&&startColumn==endColumn){
            list.add(matrix[startRow][startColumn]);
        }else {
            for (int i = startColumn; i <= endColumn; i++) {
                list.add(matrix[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                list.add(matrix[i][endColumn]);
            }
            for (int i = endColumn - 1; i >= startColumn && startRow != endRow; i--) {
                list.add(matrix[endRow][i]);
            }
            for (int i = endRow - 1; i > startRow && startColumn != endColumn; i--) {
                list.add(matrix[i][startColumn]);
            }
        }
        manipulation(matrix,startRow+1,endRow-1,startColumn+1,endColumn-1,list);
    }

    public static void main(String args[]){
        int [][]matrix={{1,2,3},
                        {4,5,6},
                        {7,8,9},
                        {10,11,12},
                        {13,14,15}};
        SpiralMatrix test=new SpiralMatrix();
        List<Integer>list=test.spiralOrder(matrix);
        for (Integer a:list){
            System.out.print(a+",");
        }
    }
}
