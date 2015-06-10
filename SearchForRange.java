/**
 * Created by JiahengYu on 31/05/15.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int result[]=new int[2];
        if (target<nums[0]||target>nums[nums.length-1]) {
            int result2[]={-1,-1};
            return result2;
        }
        int start=0;
        int end=nums.length-1;
        int occurrence=-1;
        while (start<end){
            int mid=(start+end)/2;
            if (nums[mid]==target){
                occurrence=mid;
                break;
            }else if(nums[mid]<target) {
                start=mid;
            }else if(nums[mid]>target){
                end=mid;
            }
        }
        if (occurrence==-1){
            int result2[]={-1,-1};
            return result2;
        }
        return result;
    }
}
