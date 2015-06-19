import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 19/06/15.
 */
public class NQueensII {
    int totalNumber=0;
    public int totalNQueens(int n) {
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        for (int i=0;i<n;i++){
            List<Integer>list=new LinkedList<Integer>();
            list.add(i);
            manipulation(list, 1, n);
        }
        return totalNumber;
    }
    public void manipulation(List<Integer> list,int currentLine,int Queen){
        if (currentLine==Queen){
            totalNumber++;
            return;
        }
        for (int i=0;i<Queen;i++){
            boolean place=true;
            for (int j=0;j<currentLine;j++) {
                int position = list.get(j);
                if (Math.abs(position - i) == Math.abs(j - currentLine)|| position == i) {
                    place = false;
                    break;
                }
            }
            if (place){
                List<Integer>copyList=new LinkedList<Integer>(list);
                copyList.add(i);
                int nextLine=currentLine+1;
                manipulation(copyList,nextLine,Queen);
            }
        }
    }

    public static void main(String args[]){
        System.out.print(new NQueensII().totalNQueens(4));
    }
}
