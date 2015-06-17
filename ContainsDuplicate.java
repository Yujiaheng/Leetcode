import java.util.HashSet;

/**
 * Created by JiahengYu on 17/06/15.
 */
public class ContainsDuplicate {
    /**
     * TLE
     */
//    public boolean containsDuplicate(int[] nums) {
//        if(nums==null||nums.length==0)
//            return false;
//        int check=0;
//        for (int i=0;i<nums.length;i++){
//            int temp=nums[i];
//            if ((check&(1<<temp))>0)
//                return true;
//            else {
//                check|=1<<temp;
//            }
//        }
//        return false;
//    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        if (nums==null||nums.length==0)
            return false;
        for (int i=0;i<nums.length;i++){
            int temp=nums[i];
            if (set.contains(temp))
                return true;
            else
                set.add(temp);
        }
        return false;
    }

    public static void main(String args[]){
        int a[]={1,2,3,4,5,7,8};
        System.out.print(new ContainsDuplicate().containsDuplicate(a));
    }
}
