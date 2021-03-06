/**
 * Created by JiahengYu on 15/06/15.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.min(nums[0],nums[1]);
        int start=0;
        int end=nums.length-1;
        while (start<end){
            if (nums[start]<nums[end])
                break;
            int mid=(start+end)/2;
            int temp=nums[mid];
            if (temp<nums[start]){
                end=mid;
            }else if (temp>nums[end])
                start=mid+1;
        }
        return nums[start];
    }

    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        System.out.print(new FindMinimuminRotatedSortedArray().findMin(a));
    }
}
