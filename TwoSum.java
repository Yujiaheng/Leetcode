import java.util.HashMap;

/**
 * Created by JiahengYu on 17/06/15.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int result[]=new int[2];
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>(numbers.length*3/4);
        for (int i=0;i<numbers.length;i++){
            int current=numbers[i];
            int rest=target-current;
            if (map.keySet().contains(rest)){
                result[0]=map.get(rest);
                result[1]=(i+1);
                return result;
            }else {
                map.put(current,i+1);
            }
        }
        return result;
    }


    public static void main(String args[]){
        int a[]={3,2,4};
        int result[]=new TwoSum().twoSum(a,6);
        for (int b:result){
            System.out.print(b);
        }
    }
}
