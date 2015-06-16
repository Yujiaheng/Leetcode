import java.util.Stack;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<String>();
        if (tokens==null||tokens.length==0)
            return 0;
        for (int i=0;i<tokens.length;i++){
            if (tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int operator2=Integer.parseInt(stack.pop());
                int operator1=Integer.parseInt(stack.pop());
                int result=0;
                if (tokens[i].equals("+"))
                    result=operator1+operator2;
                else if (tokens[i].equals("-"))
                    result=operator1-operator2;
                else if (tokens[i].equals("*"))
                    result=operator1*operator2;
                else if (tokens[i].equals("/"))
                    result=operator1/operator2;
                stack.push(result+"");
            }else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String args[]){
        String a[]={"4", "13", "5", "/", "+"};
        System.out.print(new EvaluateReversePolishNotation().evalRPN(a));
    }
}
