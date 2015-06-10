import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by JiahengYu on 08/06/15.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2==null||nums2.length==0)
            return;
        int one=m-1;
        int two=n-1;
        int current=nums1.length-1;
        while (one>=0&&two>=0){
            if (nums1[one]>=nums2[two]){
                nums1[current]=nums1[one];
                one--;
            }else {
                nums1[current]=nums2[two];
                two--;
            }
            current--;
        }
        while (one>=0){
            nums1[current]=nums1[one];
            one--;
            current--;
        }
        while (two>=0){
            nums1[current]=nums2[two];
            two--;
            current--;
        }
    }


    public static void main(String args[]){
        MergeSortedArray test=new MergeSortedArray();
        int a[]={1,0};
        int b[]={2};
        test.merge(a,1,b,1);
        for (Integer c:a){
            System.out.print(c);
        }
    }
}
