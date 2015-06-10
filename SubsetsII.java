import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 08/06/15.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>result=new LinkedList<List<Integer>>();
        List<Integer> list=new LinkedList<Integer>();
        if (nums==null||nums.length==0)
            return result;
        result.add(list);
        Arrays.sort(nums);
        for (int i=1;i<=nums.length;i++){
            manipulation(nums,list,result,i,0);
        }
        return result;
    }
    public void manipulation(int []nums,List<Integer> list,List<List<Integer>>result,int k,int begin){
        if (k==0){
            result.add(list);
            return;
        }
        for (int i=begin;i<nums.length;){
            List<Integer> copyList=new LinkedList<Integer>();
            copyList.addAll(list);
            copyList.add(nums[i]);
            int nextK=k-1;
            int nextBegin=i+1;
            manipulation(nums,copyList,result,nextK,nextBegin);
            do {
                i++;
            }while (i<nums.length&&nums[i-1]==nums[i]);
        }
    }



    public static void main(String args[]){
        SubsetsII test=new SubsetsII();
        int data[]={4,1,0};
        List<List<Integer>>resutl=test.subsetsWithDup(data);
        for (List<Integer> list:resutl){
            for (Integer b:list){
                System.out.print(b);
            }
            System.out.println();
        }
    }
}
