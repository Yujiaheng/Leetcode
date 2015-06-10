import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiahengYu on 29/05/15.
 */
public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<String>();
        if (digits==null||digits.length()==0)return list;
        String content[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String first=content[Integer.parseInt(digits.charAt(0)+"")-2];
        for (int i=0;i<first.length();i++)
        {
            manipulation(first.charAt(i)+"",digits.substring(1),list);
        }
        return list;
    }
    public void manipulation(String first,String digits,List<String>list){
        if (digits.length()==0){
            list.add(first);
            return;
        }
        else
        {
            String content[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            String newFirst=content[Integer.parseInt(digits.charAt(0)+"")-2];
            for (int i=0;i<newFirst.length();i++)
            {
                manipulation(first+newFirst.charAt(i),digits.substring(1),list);
            }
        }
    }
    public static void main(String args[]){
        List<String> list = new letterCombinations().letterCombinations("9");
        System.out.print(list.size());
    }
}
