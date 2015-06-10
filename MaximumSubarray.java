/**
 * Created by JiahengYu on 02/06/15.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0)return 0;
        int currentMax=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (sum>currentMax)currentMax=sum;
            if (sum<0)sum=0;
        }
        return currentMax;
    }
}
