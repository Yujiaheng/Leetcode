import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 09/06/15.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if (numRows==0)
            return result;
        List<Integer>first=new LinkedList<Integer>();
        first.add(1);
        result.add(first);
        for (int i=2;i<=numRows;i++){
            List<Integer> previous=result.get(i-2);
            List<Integer> current=new LinkedList<Integer>();
            for (int j=1;j<=i;j++){
                if (j==1||j==i)
                    current.add(1);
                else {
                    int currentNumber=previous.get(j-2)+previous.get(j-1);
                    current.add(currentNumber);
                }
            }
            result.add(current);
        }
        return result;
    }

    public static void main(String args[]){
        List<List<Integer>> result=new PascalsTriangle().generate(8);
        for (List<Integer> list:result){
            for (Integer data:list){
                System.out.print(data+",");
            }
            System.out.println();
        }
    }
}
