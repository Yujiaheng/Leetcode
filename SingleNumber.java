/**
 * Created by JiahengYu on 14/06/15.
 */
public class SingleNumber {
    /**
     * 这个只能对于正数
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int check=0;
        for (int i=0;i<nums.length;i++){
            int temp=nums[i];
            int now=1<<temp;
            if ((check&now)>0){
                check-=now;
            }else {
                check=check|now;
            }
        }
        int m=0;
        while (check!=1){
            check=check>>1;
            m++;
        }
        return m;
    }

    public int singleNumber2(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int result = 0;
        for (int i=0; i<nums.length; i++){
                result = result ^ nums[i];
        }
        return result;

    }


    public static void main(String args[]){
        SingleNumber singleNumber=new SingleNumber();
        int a[]={1,1,2,2,3,5,5,6,3,4,4};
        System.out.print(singleNumber.singleNumber2(a));
    }
}
