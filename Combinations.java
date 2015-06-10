import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 05/06/15.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if (n==0||k==0||k>n)
            return result;
        List<Integer>list=new LinkedList<Integer>();
        manipulation(list,n,k,0,result);
        return result;
    }
    public void manipulation(List<Integer> currentList,int n,int k,int current,List<List<Integer>>result){
        if (k==0) {
            result.add(currentList);
            return;
        }
        else {
            for (int i=current+1;i<=n;i++){
                List<Integer>copy= new LinkedList<Integer>();
                copy.addAll(currentList);
                copy.add(i);
                manipulation(copy,n,k-1,i,result);
            }
        }
    }
    public static void main(String args[]){
        Combinations test=new Combinations();
        List<List<Integer>> result=test.combine(4,2);
        for (List<Integer> a:result){
            for (Integer one:a)
                System.out.print(one);
            System.out.println();
        }
    }
}
