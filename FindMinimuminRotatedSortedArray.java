/**
 * Created by JiahengYu on 15/06/15.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int start=0;
        int end=nums.length-1;
        while (start<end){
            int media=(start+end)/2;
            if (min>nums[media])
                min=nums[media];
            if (nums[media]>nums[end])
                start=media+1;
            if (nums[media]<nums[end])
                end=media-1;
        }
        return min;
    }

    public static void main(String args[]){
        int a[]={2,1};
        System.out.print(new FindMinimuminRotatedSortedArray().findMin(a));
    }
}
