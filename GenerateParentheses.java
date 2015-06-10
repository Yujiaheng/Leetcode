import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 30/05/15.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list=new LinkedList<String>();
        manipulation("(",n-1,n,list);
        return list;
    }
    public void manipulation(String current,int left,int right,List<String> list){
        if (left==0&&right==0){
            list.add(current);
            return;
        }else if (left>right){
            return;
        }else{
            if (left>0)
                manipulation(current+"(",left-1,right,list);
            if (right>0)
                manipulation(current+")",left,right-1,list);
        }
    }
    public static void main(String args[]){
        GenerateParentheses g=new GenerateParentheses();
        List<String> list=g.generateParenthesis(3);
        for (String s:list){
            System.out.println(s);
        }
    }
}
