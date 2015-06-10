/**
 * Created by JiahengYu on 02/06/15.
 */
public class JumpGame {
    /**
     * 超时
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums==null)
            return false;
        if (nums.length==0)
            return true;
        int maxStep=nums[0];
        if (nums.length==1&&nums[0]>=0)return true;
        for (int i=1;i<nums.length;i++){
            if (i<=maxStep){
                if (maxStep>=nums.length-1)
                    return true;
                else
                    maxStep=Math.max(maxStep,i+nums[i]);
            }
        }
        if (maxStep>=nums.length)
            return true;
        else
            return false;
    }


    public static void main(String args[]){
        int a[]={0,1};
        System.out.print(canJump(a));
    }
}
