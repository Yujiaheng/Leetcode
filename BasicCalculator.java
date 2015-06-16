import java.util.Stack;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class BasicCalculator {
    public int calculate(String s) {
        if (s==null)
            return 0;
        Stack<String>stack=new Stack<String>();
        for (int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if (temp=='('){
                stack.push(" "+temp);
            }else if (temp==')'){
                StringBuffer stringBuffer=new StringBuffer();
                String one=stack.pop();
                stringBuffer.append(one);
                while (!one.equals(" (")){
                    one=stack.pop();
                    stringBuffer.append(one);
                }
                String a[]=stringBuffer.toString().split(" ");
                StringBuffer stringBuffer1=new StringBuffer();
                for (int j=a.length-2;j>=0;j--){
                    stringBuffer1.append(a[j]);
                    stringBuffer1.append(" ");
                }
                String ev=stringBuffer1.toString().trim();
                int result=evaluate(ev);
                stack.push(" "+result);
            }else if (temp!=' '){
                stack.push(" "+temp);
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        while (!stack.isEmpty()){
            String one=stack.pop();
            stringBuffer.append(one);
        }
        String a[]=stringBuffer.toString().split(" ");
        StringBuffer stringBuffer1=new StringBuffer();
        for (int j=a.length-1;j>=0;j--){
            stringBuffer1.append(a[j]);
            stringBuffer1.append(" ");
        }
        String ev=stringBuffer1.toString().trim();
        int result=evaluate(ev);
        return result;
    }


    public int evaluate(String s){
        String[] array=s.split(" ");
        int tempResult=Integer.parseInt(array[0]);
        for (int i=1;i<array.length;i++) {
            String temp =array[i];
            if (temp.equals("+")){
                int another=Integer.parseInt(array[i+1]);
                tempResult+=another;
            }else if (temp.equals("-")){
                int another=Integer.parseInt(array[i+1]);
                tempResult-=another;
            }
        }
        return tempResult;
    }

    public static void main(String args[]){
        BasicCalculator test=new BasicCalculator();
        System.out.print(test.calculate("1 + 1"));
    }
}
