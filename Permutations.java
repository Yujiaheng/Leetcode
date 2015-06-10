import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 02/06/15.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums==null||nums.length==0)return result;
        List<Integer> list=new LinkedList<Integer>();
        manipulation(nums,list,result);
        return result;
    }
    public void manipulation(int[] nums,List<Integer>current,List<List<Integer>>result){
        if (nums.length==0){
            result.add(current);
            return;
        }

        for (int i=0;i<nums.length;i++){
            LinkedList<Integer> copy=new LinkedList<Integer>();
            for (Integer a:current)
                copy.add(a);
            copy.add(nums[i]);
            int temp[]=new int[nums.length-1];
            for (int j=0;j<nums.length;j++){
                if (j<i)
                    temp[j]=nums[j];
                else if (j>i)
                    temp[j-1]=nums[j];
            }
            manipulation(temp,copy,result);
        }
    }

    //chaoshi
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums==null||nums.length==0)return result;
        List<Integer> list=new LinkedList<Integer>();
        manipulation2(nums,list,result);
        return result;
    }
    public void manipulation2(int[] nums,List<Integer>current,List<List<Integer>>result){
        if (nums.length==0){
            if (!result.contains(current))
                result.add(current);
            return;
        }

        for (int i=0;i<nums.length;i++){
            LinkedList<Integer> copy=new LinkedList<Integer>();
            for (Integer a:current)
                copy.add(a);
            copy.add(nums[i]);
            int temp[]=new int[nums.length-1];
            for (int j=0;j<nums.length;j++){
                if (j<i)
                    temp[j]=nums[j];
                else if (j>i)
                    temp[j-1]=nums[j];
            }
            manipulation(temp,copy,result);
        }
    }

    public static void main(String args[]){
        Permutations a=new Permutations();
        int []temp={0,1};
        a.permute(temp);
    }
}
