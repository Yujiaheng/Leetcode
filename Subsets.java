import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 05/06/15.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if (nums==null||nums.length==0)
            return result;
        Arrays.sort(nums);
        List<Integer>list=new LinkedList<Integer>();
        result.add(list);
        for (int k=1;k<=nums.length;k++){
            manipulation(list,nums,result,k,0);
        }
        return result;
    }
    public void manipulation(List<Integer>currentList,int[]nums,List<List<Integer>>result,int k,int currentLocation){
        if (k==0) {
            result.add(currentList);
            return;
        }
        for (int i=currentLocation;i<nums.length;i++){
            List<Integer>copyList=new LinkedList<Integer>();
            copyList.addAll(currentList);
            copyList.add(nums[i]);
            int nextBegin=i+1;
            int nextSubSetSize=k-1;
            manipulation(copyList,nums,result,nextSubSetSize,nextBegin);
        }
    }
    public static void main(String arg[]){
        Subsets test=new Subsets();
        int data[]={1,2,3,4,5};
        List<List<Integer>>result=test.subsets(data);
        for (List<Integer> one:result){
            for (Integer two:one){
                System.out.print(two);
            }
            System.out.println();
        }
    }
}
