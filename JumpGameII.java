/**
 * Created by JiahengYu on 10/06/15.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int minSteps=0;
        if (nums==null||nums.length==0)
            return 0;
        if (nums.length==1&&nums[0]>=0)
            return 0;
        int maxSteps=nums[0];
        int maxStepCopy=nums[0];
        for (int i=1;i<nums.length;i++){
            if (i<=maxSteps){
                if (maxSteps>=nums.length-1)
                    return minSteps+1;
                maxStepCopy=Math.max(maxStepCopy,i+nums[i]);
                if (i==maxSteps){
                    minSteps++;
                    maxSteps=maxStepCopy;
                }

            }
        }
        return minSteps;
    }
}
