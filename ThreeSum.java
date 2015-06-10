import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 29/05/15.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        Arrays.sort(num);
        for (int i=0;i<num.length-2;){
            int start=i+1;
            int end=num.length-1;
            while (start<end){
                if (num[start]+num[end]+num[i]==0){
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[start]);
                    temp.add(num[end]);
                    result.add(temp);
                    do{
                        start++;
                    }while (start<end&&num[start]==num[start-1]);
                    do {
                        end--;
                    }while (start<end&&num[end]==num[end+1]);
                }else if(num[start]+num[end]+num[i]>0){
                    end--;
                }else if (num[start]+num[end]+num[i]<0){
                    start++;
                }
            }
            do{
                i++;
            }while (i<num.length-2&&num[i]==num[i-1]);
        }
        return result;
    }
}
