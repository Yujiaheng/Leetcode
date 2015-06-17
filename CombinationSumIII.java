import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 17/06/15.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if (n<0)
            return result;
        if (n>50)
            return result;
        List<Integer> list=new LinkedList<Integer>();
        manipulation(result,list,1,n,k);
        return result;
    }

    private void manipulation(List<List<Integer>> result,List<Integer>list,int current,int resValue,int resNo){
        if(resNo==0){
            if (resValue==0){
                result.add(list);
                return;
            }else
                return;
        }
        if (resValue==0&&resNo!=0)
            return;

        for (int i=current;i<=9;i++){
            if (resValue-i>=0){
                List<Integer> copyList=new LinkedList<Integer>(list);
                copyList.add(i);
                int newRes=resValue-i;
                int newResNo=resNo-1;
                int newCurrent=i+1;
                manipulation(result,copyList,newCurrent,newRes,newResNo);
            }
        }
    }

    public static void main(String args[]){
        CombinationSumIII test=new CombinationSumIII();
        List<List<Integer>> result=test.combinationSum3(3,9);
        for (List<Integer> list:result){
            for (int a:list){
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
