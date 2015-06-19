/**
 * Created by JiahengYu on 19/06/15.
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.min(nums[0],nums[1]);
        int start=0;
        int end=nums.length-1;
        while (start<end){
            if (nums[start]==nums[end]){
                start++;
                continue;
            }
            if (nums[start]<nums[end]){
                break;
            }
            int mid=(start+end)/2;
            if (nums[mid]<nums[start]){
                end=mid;
            }else {
                start=mid+1;
            }
        }
        return nums[start];
    }

    public static void main(String args[]){
        int a[]={2,0,1,1,1};
        System.out.print(new FindMinimuminRotatedSortedArrayII().findMin(a));
    }
}
