/**
 * Created by JiahengYu on 07/06/15.
 */
public class RemoveDuplicatesfromSorted {
    public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        int result=nums.length;
        int count=1;
        int currentNumber=nums[0];
        int currentPlace=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==currentNumber){
                count--;
                if (count<0) {
                    result--;
                } else {
                    nums[currentPlace]=nums[i];
                    currentPlace++;
                }
            }else {
                count=1;
                currentNumber=nums[i];
                nums[currentPlace]=nums[i];
                currentPlace++;
            }
        }
        return result;
    }

    public static void main(String args[]){
        RemoveDuplicatesfromSorted test=new RemoveDuplicatesfromSorted();
        int a[]={1,1,1,2,2,3};
        System.out.println(test.removeDuplicates(a));
        for (Integer b:a){
            System.out.print(b);
        }
    }
}
