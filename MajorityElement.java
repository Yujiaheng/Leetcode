import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i]))
                map.replace(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        for (Integer k:map.keySet()){
            if (map.get(k)>nums.length/2)
                return k;
        }
        return 0;
    }
    /**
     * Moore voting algorithm
     */
    public int majorityElement2(int[] nums) {
        int count=0;
        int element=0;
        for (int i=0;i<nums.length;i++){
            if (count==0){
                element=nums[i];
                count++;
            }else {
                if (element==nums[i])
                    count++;
                else count--;
            }
        }
        return element;
    }
}
