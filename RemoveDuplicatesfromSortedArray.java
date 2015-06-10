/**
 * Created by JiahengYu on 30/05/15.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
            int len=nums.length;
            if(len==0) return 0;
            int prev=nums[0],res=1,val;
            for(int i=1;i<len;i++){
                val = nums[i];
                if(prev!=val){
                    prev=val;
                    nums[res]=val;
                    res++;
                }
            }
            return res;
        }

    public static void main(String args[]){
        RemoveDuplicatesfromSortedArray a= new RemoveDuplicatesfromSortedArray();
        int b[]={1,1,2};
        a.removeDuplicates(b);
        for (int i:b){
            System.out.print(i);
        }
    }
}
