/**
 * Created by JiahengYu on 18/06/15.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while( left <= right){
                int mid = (left + right)/2;
                if(nums[mid] == target) return mid;
                if(nums[left] < nums[mid]){
                    if(target <= nums[mid] && target >= nums[left])
                        right = mid - 1;
                    else left = mid + 1;
                } else if (nums[left] > nums[mid]){
                    if(target >= nums[left] || target <= nums[mid])
                        right = mid -1;
                    else left = mid + 1;
                }
                else left ++;
            }
            return -1;
        }

    public static void main(String args[]){
        //int a[]={4,5,6,7,0,1,2};
        int a[]={1,3};
        System.out.print(new SearchinRotatedSortedArray().search(a,2));
    }
}
