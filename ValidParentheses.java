import java.util.Stack;

/**
 * Created by JiahengYu on 30/05/15.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        boolean valid=true;
        Stack<Character> stack=new Stack<Character>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='(')
                stack.push(s.charAt(i));
            if (s.charAt(i)=='}'||s.charAt(i)==']'||s.charAt(i)==')'){
                if (stack.isEmpty()) return false;
                Character ch=stack.pop();
                if (s.charAt(i) =='}'&& ch!='{') return false;
                if (s.charAt(i) ==']'&& ch!='[') return false;
                if (s.charAt(i) ==')'&& ch!='(') return false;
            }
        }
        if (!stack.isEmpty())return false;
        return valid;
    }
    public static void main(String args[]){
        System.out.print(isValid("([)]"));
    }
}
