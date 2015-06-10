import java.util.*;

/**
 * Created by JiahengYu on 01/06/15.
 */
public class CombinationSum {

    class ListNodeComparator implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2 ) {
            if (o1>o2)
                return 1;
            else if (o1<o2)
                return -1;
            else
                return 0;
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer>list=new LinkedList<Integer>();
        manipulation(candidates,target,result,list,0);
        return result;
    }

    public void manipulation(int[]candidates,int target,List<List<Integer>>result,List<Integer>currentList,int currentIndex){
        if (target==0){
            currentList.sort(new ListNodeComparator());
            result.add(currentList);
            return;
        }else {
            for (int i=currentIndex;i<candidates.length;){
                if (target-candidates[i]>=0) {
                    List<Integer>copyList=new LinkedList<Integer>();
                    for(Integer a: currentList)
                        copyList.add(a);
                    int newTarget=target-candidates[i];
                    copyList.add(candidates[i]);
                    manipulation(candidates, newTarget, result, copyList,i+1);
                }
                do {
                    i++;
                }while (i<candidates.length&&candidates[i]==candidates[i-1]);
            }
        }
    }
}
