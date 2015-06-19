/**
 * Created by JiahengYu on 19/06/15.
 */
public class SearchforaRange {
    static int start=-1;
    static int end=-1;
    public int[] searchRange(int[] nums, int target) {
        int resultFalse[]={-1,-1};
        if (nums==null||nums.length==0)
            return resultFalse;
        int one=0;
        int two=nums.length-1;
        manipulation(nums,one,two,target);
        int result[]={start,end};
        return result;
    }

    private void manipulation(int []nums,int one,int two,int target){
        if (one>two)
            return;
        int mid=(one+two)/2;
        if (nums[mid]==target){
            if (mid>end)
                end=mid;
            if (mid<start||start<0)
                start=mid;
            manipulation(nums,one,mid-1,target);
            manipulation(nums,mid+1,two,target);
        }else if (nums[mid]>target){
            manipulation(nums,one,mid-1,target);
        }else if(nums[mid]<target){
            manipulation(nums,mid+1,two,target);
        }
    }
    public static void main(String args[]){
        //int a[]={5, 7, 7, 8, 8, 10};
        int a[]={2,2};
        int b[]=new SearchforaRange().searchRange(a,1);
        for (int c:b){
            System.out.print(c);
        }
    }
}
