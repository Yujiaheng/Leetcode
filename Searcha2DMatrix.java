/**
 * Created by JiahengYu on 05/06/15.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result=false;
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int start=0;
        int end=matrix.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (matrix[mid][0]==target)
                return true;
            else if (matrix[mid][0]>target)
                end=mid-1;
            else if (matrix[mid][0]<target)
                start=mid+1;
        }
        int row=end;
        if (row<0)
            return result;
        start=0;
        end=matrix[0].length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (matrix[row][mid]==target)
                return true;
            else if (matrix[row][mid]>target)
                end=mid-1;
            else if (matrix[row][mid]<target)
                start=mid+1;
        }
        return result;
    }
}
