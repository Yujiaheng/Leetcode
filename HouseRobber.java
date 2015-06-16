/**
 * Created by JiahengYu on 15/06/15.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int max[]=new int[nums.length];
        if (nums==null||nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return nums[1]>nums[0]?nums[1]:nums[0];
        max[0]=nums[0];
        max[1]=nums[1]>nums[0]?nums[1]:nums[0];
        for (int i=2;i<nums.length;i++){
            max[i]=Math.max(max[i-2]+nums[i],max[i-1]);
        }
        return max[max.length-1];
    }
}
