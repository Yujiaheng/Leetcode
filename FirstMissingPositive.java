/**
 * Created by JiahengYu on 01/06/15.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0){
                int position=nums[i]-1;
                int temp=nums[position];
                nums[position]=nums[i];
                nums[i]=temp;
            }
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length;
    }
}
