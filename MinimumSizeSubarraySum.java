/**
 * Created by JiahengYu on 16/06/15.
 */
public class MinimumSizeSubarraySum {
//    static int result=Integer.MAX_VALUE;
//    public int minSubArrayLen(int s, int[] nums) {
//        manipulation(s,s,nums,0);
//        return result;
//    }
//    public void manipulation(int s,int ret,int []nums, int start){
//        if(ret<=0){
//            if (7+Math.abs(ret)<result)
//                result=s+Math.abs(ret);
//            return;
//        }
//        for (int i=start;i<nums.length;i++){
//            int currentRet=ret-nums[i];
//            manipulation(s,currentRet,nums,i);
//        }
//    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        int min=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        for (int i=0;i<nums.length;i++){
            end+=nums[i];
            if (end>=s){
                while (end>=s){
                    min=min>(i-start+1)?(i-start+1):min;
                    end-=nums[start];
                    start++;
                }
            }
        }
        if (min==Integer.MAX_VALUE)
            return 0;
        return min;
    }

    public static void main(String args[]){
        int a[]={2,3,1,1,1,1,1};
        System.out.print(new MinimumSizeSubarraySum().minSubArrayLen(5,a));
    }
}
