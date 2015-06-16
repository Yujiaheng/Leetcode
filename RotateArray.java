import java.util.Stack;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class RotateArray {

    /**
     * tle
     */

//    public void rotate(int[] nums, int k) {
//        if (k<=0||k>nums.length)
//            return;
//        Stack<Integer> stack=new Stack<Integer>();
//        int index=nums.length-k;
//        for (int i=0;i<index;i++)
//            stack.push(nums[i]);
//        for (int i=nums.length-1;i>=index;i--)
//            stack.push(nums[i]);
//        for (int i=0;i<nums.length;i++){
//            nums[i]=stack.pop();
//        }
//    }


    //[1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
    public void rotate(int[] nums, int k) {
        int copy[]=new int[nums.length];
        if (k<=0)
            return;
        if (k>nums.length)
            k=k%nums.length;
        if (k==nums.length)
            return;
        int j=0;
        for (int h=0,i=nums.length-k;h<nums.length;h++,i++){
            if (i>nums.length-1)
                i=i%nums.length;
            copy[j]=nums[i];
            j++;
        }
        int i=0;
        for (int m:copy){
            nums[i]=m;
            i++;
        }
    }

    public static void main(String args[]){
        int []a={1,2,3,4,5,6,7};
        new RotateArray().rotate(a,3);
        for (int b:a)
            System.out.print(b);
    }
}
