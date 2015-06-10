import com.apple.eawt.AppEvent;

import java.util.Stack;

/**
 * Created by JiahengYu on 01/06/15.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()==0||s.length()==1)return 0;
        int maxLength=0;
        Stack<Character> stack=new Stack<Character>();
        int one=0;
        while (one<s.length()&&s.charAt(one)!='('){
            one++;
        }
        if (one>=s.length())
            return 0;
        s=s.substring(one);
        boolean dp[][]=new boolean[s.length()][s.length()];
        for (int i=0;i<s.length()-1;i++){
            if (s.charAt(i)=='('&&s.charAt(i+1)==')'){
                dp[i][i+1]=true;
                maxLength=2;
            }
        }
        for (int length=4;length<=s.length();length+=2) {
            for (int i = 0; i <=s.length() - length; i++) {
                int j = i + length-1;
                if (dp[i + 1][j - 1] && s.charAt(i) == '(' && s.charAt(j) == ')') {
                    dp[i][j] = true;
                    maxLength = length;
                } else {
                    for (int start = i + 1; start < j - 2; start++) {
                        if (dp[i][start] && dp[start + 1][j]) {
                            dp[i][j] = true;
                            maxLength = j - i;
                        }
                    }
                }
            }
        }
        return maxLength;
    }


    public int longestValidParentheses2(String s) {
        if(s==null||s.length()==0||s.length()==1)return 0;
        int maxLength=0;
        Stack<Character> stack=new Stack<Character>();
        int one=0;
        while (one<s.length()&&s.charAt(one)!='('){
            one++;
        }
        if (one>=s.length())
            return 0;
        for (int i=one;i<s.length();i++){
            if (s.charAt(i)=='(')
                stack.push(s.charAt(i));
            else {
                if (!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                    if (maxLength<i-stack.size())maxLength=i-stack.lastElement();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return maxLength;
    }


    public static void main(String args[]){
        LongestValidParentheses a= new LongestValidParentheses();
        int i=a.longestValidParentheses2("(())");
        System.out.print(i);
    }
}
