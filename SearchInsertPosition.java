/**
 * Created by JiahengYu on 01/06/15.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int index=-1;
        if (nums.length==0)return 0;
        else if (nums.length>0){
            if (target<nums[0])return 0;
            if (target>nums[nums.length-1])return nums.length;
            int start=0;
            int end=nums.length-1;
            while(start<=end){
                int mid=(start+end)/2;
                if (nums[mid]==target){
                    return mid;
                }else if (nums[mid]>target){
                    end=mid-1;
                }else if (nums[mid]<target){
                    start=mid+1;
                }
            }
            return end+1;
        }
        return index;
    }

    public static void main(String args[]){
        SearchInsertPosition a =new SearchInsertPosition();
        int temp[]={1,3,5,6};
        System.out.print(a.searchInsert(temp, 0));
    }
}
