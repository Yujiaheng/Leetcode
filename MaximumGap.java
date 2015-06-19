import sun.nio.cs.ext.MacThai;

/**
 * Created by JiahengYu on 19/06/15.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums==null||nums.length<2){
            return 0;
        }
        quickSort(nums,0,nums.length-1);
        int maxGap=Integer.MIN_VALUE;
        for (int i=1;i<nums.length;i++){
            maxGap= Math.max(maxGap,nums[i]-nums[i-1]);
        }
        return maxGap;
    }
    private void quickSort(int []nums,int start,int end){
        if (start<end){
            int i=start;
            int j=end;
            int x=nums[i];
            while (i<j){
                while (i<j&&nums[j]>=x){
                    j--;
                }
                if (i<j){
                    nums[i++]=nums[j];
                }
                while (i<j&&nums[i]<x){
                    i++;
                }
                if (i<j){
                    nums[j--]=nums[i];
                }
            }
            nums[i]=x;
            quickSort(nums,start,i-1);
            quickSort(nums,i+1,end);
        }
    }
}
