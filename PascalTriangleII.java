import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 09/06/15.
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new LinkedList<Integer>();
        if (rowIndex<0)
            return list;
        if (rowIndex==0){
            list.add(1);
            return list;
        }
        int a[]=new int[rowIndex+1];
        a[0]=1;
        for (int i=1;i<=rowIndex;i++){
            for (int j=i;j>=0;j--){
                if (j==i)
                    a[j]=1;
                else if (j==0)
                    a[j]=1;
                else
                    a[j]=a[j]+a[j-1];
            }
        }
        for (int i=0,j=a.length-1;i<rowIndex+1;i++,j--)
            list.add(a[j]);
        return list;
    }


    public static void main(String args[]){
        PascalTriangleII test=new PascalTriangleII();
        List<Integer> result=test.getRow(5);
        for (int a:result)
            System.out.print(a+",");
    }
}
