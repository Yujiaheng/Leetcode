import java.util.Stack;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        Stack<Character> stack=new Stack<Character>();
        for (int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        int i=0;
        int result=0;
        while (!stack.isEmpty()){
            char temp=stack.pop();
            result+=(temp-'A'+1)*Math.pow(26,i);
            i++;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.print(new ExcelSheetColumnNumber().titleToNumber("AA"));
    }
}
