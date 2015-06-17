/**
 * Created by JiahengYu on 17/06/15.
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        manipulation(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    private void manipulation(int []nums,int start,int end){
        if (start<end){
            int i=start,j=end,x=nums[start];
            while (i<j){
                while (i<j&&nums[j]>=x){
                    j--;
                }
                if (i<j){
                    nums[i]=nums[j];
                    i++;
                }
                while (i<j&&nums[i]<x){
                    i++;
                }
                if (i<j){
                    nums[j]=nums[i];
                    j--;
                }
            }
            nums[i]=x;
            manipulation(nums,start,i-1);
            manipulation(nums,i+1,end);
        }
    }

    public static void main(String args[]){
        int a[]={3,2,1,5,6,4};
        new KthLargestElementinanArray().findKthLargest(a,2);
        for (int m:a){
            System.out.print(m);
        }
        //System.out.print(new KthLargestElementinanArray().findKthLargest(a,2));
    }
}
