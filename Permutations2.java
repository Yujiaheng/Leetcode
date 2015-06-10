import java.util.*;

/**
 * Created by JiahengYu on 02/06/15.
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if (nums==null||nums.length==0)return result;
        List<Integer> list=new LinkedList<Integer>();
        manipulation(nums,list,result);
        Arrays.sort(nums);
        return result;
    }
    public void manipulation(int nums[],List<Integer> current, List<List<Integer>> result){
        if (nums.length==0) {
            result.add(current);
            return;
        }
        for (int i=0;i<nums.length;){
            List<Integer> copy=new LinkedList<Integer>();
            Collections.copy(copy,current);
            int []temp=new int[nums.length-1];
            for (int j=0;j<nums.length;j++){
                if (j<i)
                    temp[j]=nums[j];
                else if (j>i)
                    temp[j-1]=nums[j];
            }
            copy.add(nums[i]);
            manipulation(temp,copy,result);
            do{
                i++;
            }while (i<nums.length&&nums[i-1]==nums[i]);
        }
    }




    public static void main(String args[]){
        Permutations2 a=new Permutations2();
        int b[]={1,1};
        List<List<Integer>>temp=a.permuteUnique(b);
    }
}
