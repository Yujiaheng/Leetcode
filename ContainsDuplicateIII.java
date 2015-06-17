import java.util.TreeSet;

/**
 * Created by JiahengYu on 17/06/15.
 */
public class ContainsDuplicateIII {
    //j-i<=k   nums[j]-nums[i]<=t
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        for (int i=0;i<nums.length-k;i++){
//            for (int j=i+1;j<Math.min(i+k,nums.length);j++){
//                if (Math.abs(nums[i]-nums[j])<=t){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1||t<0) return false;
        TreeSet<Integer> set=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            if ((set.floor(temp)!=null&&temp<=(t+set.floor(temp)))||set.ceiling(temp)!=null&&temp>=set.ceiling(temp)-t){
                return true;
            }
            set.add(nums[i]);
            if (i>=k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
