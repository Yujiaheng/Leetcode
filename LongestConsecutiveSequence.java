import java.util.HashSet;

/**
 * Created by JiahengYu on 10/06/15.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        if (nums.length==1)
            return 1;
        HashSet<Integer> set=new HashSet<Integer>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxLenght=1;
        for (int i=0;i<nums.length;i++){
            int currentNum=nums[i];
            int length=1;
            int nextNumber=currentNum+1;
            while (set.contains(nextNumber)){
                length++;
                set.remove(nextNumber);
                nextNumber++;
            }
            int previousNumber=nums[i]-1;
            while (set.contains(previousNumber)){
                length++;
                set.remove(previousNumber);
                previousNumber--;
            }
            if (length>maxLenght)
                maxLenght=length;
        }
        return maxLenght;
    }
}
