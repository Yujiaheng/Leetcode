import com.apple.eawt.AppEvent;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by JiahengYu on 01/06/15.
 */
public class LongestValidParentheses {
//    public int longestValidParentheses(String s) {
//        if(s==null||s.length()==0||s.length()==1)return 0;
//        int maxLength=0;
//        Stack<Character> stack=new Stack<Character>();
//        int one=0;
//        while (one<s.length()&&s.charAt(one)!='('){
//            one++;
//        }
//        if (one>=s.length())
//            return 0;
//        s=s.substring(one);
//        boolean dp[][]=new boolean[s.length()][s.length()];
//        for (int i=0;i<s.length()-1;i++){
//            if (s.charAt(i)=='('&&s.charAt(i+1)==')'){
//                dp[i][i+1]=true;
//                maxLength=2;
//            }
//        }
//        for (int length=4;length<=s.length();length+=2) {
//            for (int i = 0; i <=s.length() - length; i++) {
//                int j = i + length-1;
//                if (dp[i + 1][j - 1] && s.charAt(i) == '(' && s.charAt(j) == ')') {
//                    dp[i][j] = true;
//                    maxLength = length;
//                } else {
//                    for (int start = i + 1; start < j - 2; start++) {
//                        if (dp[i][start] && dp[start + 1][j]) {
//                            dp[i][j] = true;
//                            maxLength = j - i;
//                        }
//                    }
//                }
//            }
//        }
//        return maxLength;
//    }
//
//
//    public int longestValidParentheses2(String s) {
//        if(s==null||s.length()==0||s.length()==1)return 0;
//        int maxLength=0;
//        Stack<Character> stack=new Stack<Character>();
//        int one=0;
//        while (one<s.length()&&s.charAt(one)!='('){
//            one++;
//        }
//        if (one>=s.length())
//            return 0;
//        for (int i=one;i<s.length();i++){
//            if (s.charAt(i)=='(')
//                stack.push(s.charAt(i));
//            else {
//                if (!stack.isEmpty()&&stack.peek()=='('){
//                    stack.pop();
//                    if (maxLength<i-stack.size())maxLength=i-stack.lastElement();
//                }else{
//                    stack.push(s.charAt(i));
//                }
//            }
//        }
//        return maxLength;
//    }
    //(()) ()(
//    public int longestValidParentheses(String s) {
//        if (s==null||s.length()==0||s.length()==1)
//            return 0;
//        int dp[][]=new int[s.length()][s.length()];
//        for (int i=0;i<s.length();i++){
//            dp[i][i]=0;
//        }
//        for (int i=0;i<s.length()-1;i++){
//            if (s.charAt(i)=='('&&s.charAt(i+1)==')')
//                dp[i][i+1]=2;
//        }
//        for (int length=3;length<s.length();length++){
//            for (int start=0;start<=s.length()-length;start++){
//                int end=start+length-1;
//                if (s.charAt(end)=='(')
//                    dp[start][end]=dp[start][end-1];
//                else if (s.charAt(end)==')'){
//                    //()())(   )
//                }
//            }
//        }
//        return dp[s.length()-1][s.length()-1];
//        return 0;
//    }



    //()(()() == 4
    public int longestValidParentheses(String s) {
        int result=0;
        if (s==null||s.trim().length()<=1)
            return 0;
        Stack stack=new Stack();
        while (s.length()>0&&s.charAt(0)==')'){
            s=s.substring(1);
        }
        if (s.length()==0) {
            return 0;
        }
        int countOfLeft=0;
        for (int i=0;i<s.length();i++){
            if (new Character(s.charAt(i)).equals('(')) {
                stack.push(new Character(s.charAt(i)));
                countOfLeft++;
            } else {
                if (countOfLeft>0){
                    int currentResult=2;
                    while (!stack.peek().equals('(')){
                        currentResult+=(Integer)stack.pop();
                    }
                    stack.pop();
                    countOfLeft--;
                    stack.push(currentResult);
                }else {
                    int tempresult=0;
                    while (!stack.isEmpty()){
                        tempresult+=(Integer)stack.pop();
                    }
                    result=Math.max(tempresult,result);
                }
            }
        }
        int tempResult=0;
        while (!stack.isEmpty()){
            if (!stack.peek().equals('(')) {
                tempResult+= (Integer) stack.pop();
            }
            else {
                result=Math.max(tempResult,result);
                tempResult=0;
                stack.pop();
            }
        }
        result=Math.max(tempResult,result);
        return result;
    }





    public static void main(String args[]){
        LongestValidParentheses a= new LongestValidParentheses();
        int i=a.longestValidParentheses(")()())()()(");
        System.out.print(i);
        //System.out.print(new Character('(').equals('('));
    }
}
