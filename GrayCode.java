import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 08/06/15.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new LinkedList<Integer>();
        for (int i=0;i<Math.pow(2,n);i++){
            int current=i;
            int previous=i<<1;
            int temp=current^previous;
            temp=temp>>1;
            result.add(temp);
        }
        return result;
    }
}
