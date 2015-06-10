/**
 * Created by JiahengYu on 30/05/15.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums==null||nums.length==0)return 0;
        if (nums.length==1) {
            if (nums[0]==val)
                return 0;
            else
                return 1;
        }
        int res=0;
        for (int i=0;i<nums.length;i++){
            if (val!=nums[i]){
                nums[res]=nums[i];
                res++;
            }
        }
        return res;
    }
}
