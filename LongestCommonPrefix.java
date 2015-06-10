import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by JiahengYu on 29/05/15.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs==null&&strs.length==0)return null;
        if (strs.length==1)return strs[0];
        Arrays.sort(strs);
        String result=strs[0];
        for (int i=1;i<strs.length;i++){
            if (!strs[i].startsWith(result)){
                do {
                    result=new String(result.substring(0,result.length()-1));
                }while (!strs[i].startsWith(result));
            }
        }
        return result;
    }
    public static void main(String argss[]){
        String a[]={"ca","a"};
        System.out.print(longestCommonPrefix(a));
    }
}
