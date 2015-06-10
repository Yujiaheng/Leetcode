import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 03/06/15.
 */
public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result=new LinkedList<String[]>();
        if (n<=0) return result;
        String []current=new String [n];
        manipulation(0,current,result);
        return result;
    }
    public void manipulation(int queen, String[]current,List<String[]>result){
        if (queen==current.length)
            result.add(current);
        for (int i=0;i<current.length;i++){
            String []copy=new String[current.length];
            int h=0;
            for (String temp:current){
                copy[h]=temp;
                h++;
            }
            boolean place=true;
            for (int j=0;j<queen;j++){
                String oneLine=current[j];
                int position=queen-j;
                if (oneLine.charAt(i)=='Q') {
                    place = false;
                    break;
                }
                if (i-position>=0&&oneLine.charAt(i-position)=='Q'){
                    place = false;
                    break;
                }
                if (i+position<current.length&&oneLine.charAt(i+position)=='Q'){
                    place = false;
                    break;
                }
            }
            if (place){
                StringBuffer stringBuffer=new StringBuffer();
                for (int m=0;m<current.length;m++){
                    if (m==i){
                        stringBuffer.append("Q");
                    }
                    else
                        stringBuffer.append(".");
                }
                copy[queen]=stringBuffer.toString();
                manipulation(queen+1,copy,result);
            }
        }
    }
}
