/**
 * Created by JiahengYu on 15/06/15.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int maxProduct=nums[0];
        int max_temp=nums[0];
        int min_temp=nums[0];

        for (int i=1;i<nums.length;i++){
            int a=nums[i]*max_temp;
            int b=nums[i]*min_temp;
            max_temp=Math.max(Math.max(a,b),nums[i]);
            min_temp=Math.min(Math.min(a,b),nums[i]);
            maxProduct=Math.max(max_temp,maxProduct);
        }
        return maxProduct;
    }

    public static void main(String args[]){
        int a[]={-2,-3,1,0,9,2};
        System.out.print(new MaximumProductSubarray().maxProduct(a));
    }
}
