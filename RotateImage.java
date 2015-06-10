/**
 * Created by JiahengYu on 02/06/15.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        //first fanzhuan the matrix
        move(matrix);
        transform(matrix,0);
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[0].length;j++)
//                System.out.print(matrix[i][j]);
//            System.out.println();
//        }
    }
    private void move(int [][]matrix){
        for (int top=0,bottom=matrix.length-1;top<bottom;top++,bottom--){
            for (int i=0;i<matrix[0].length;i++){
                int temp=matrix[top][i];
                matrix[top][i]=matrix[bottom][i];
                matrix[bottom][i]=temp;
            }
        }
    }

    private void transform(int [][]matrix, int dimention){
        if (dimention==matrix.length-1){
            return;
        }else{
            for (int i=dimention;i<matrix.length;i++){
                int temp=matrix[dimention][i];
                matrix[dimention][i]=matrix[i][dimention];
                matrix[i][dimention]=temp;
            }
            dimention++;
            transform(matrix,dimention);
        }
    }

    public static void main(String args[]){
        RotateImage test=new RotateImage();
        int img[][]={{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};
        test.rotate(img);
    }
}
