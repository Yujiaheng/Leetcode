import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by JiahengYu on 02/06/15.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        StringBuffer result;
        Queue<String> queue=new ConcurrentLinkedQueue<String>();
        boolean minus=false;
        int carry=0;
        if (num1==null||num2==null||num1.length()==0||num2.length()==0)
            return null;
        if (num1.startsWith("-")) {
            minus = !minus;
            num1=num1.substring(1);
            if (num1.equals(""))
                return null;
        }
        if (num2.startsWith("-")) {
            minus = !minus;
            num2=num2.substring(1);
            if (num2.equals(""))
                return null;
        }
        //multiplication
        for (int i=num1.length()-1;i>=0;i--){
            int one=Integer.parseInt(num1.charAt(i)+"");
            result=new StringBuffer();
            for (int j=num2.length()-1;j>=0;j--){
                int two=Integer.parseInt(num2.charAt(j)+"");
                int three=one*two+carry;
                if (three>=10){
                    carry=three/10;
                    result.append(three%10);
                }else {
                    carry=0;
                    result.append(three);
                }
            }
            if (carry!=0)
                result.append(carry);
            carry=0;
            queue.add(result.reverse().toString());
        }
        int times=queue.size();
        for (int i=0;i<times;i++){
            StringBuffer temp=new StringBuffer(queue.poll());
            for (int j=0;j<i;j++){
                temp.append("0");
            }
            queue.add(temp.toString());
        }
        //接下来是要相加
//        for (String a:queue){
//            System.out.println(a);
//        }
//

        String currentResult=queue.poll();
        carry=0;
        while (!queue.isEmpty()){
            StringBuffer temp=new StringBuffer();
            String next=queue.poll();
            int one=currentResult.length()-1;
            int two=next.length()-1;
            while (one>=0&&two>=0){
                int first=Integer.parseInt(currentResult.charAt(one)+"");
                int second=Integer.parseInt(next.charAt(two)+"");
                int three=first+second+carry;
                carry=0;
                if (three>=10){
                    carry=three/10;
                    temp.append(three%10);
                }else
                    temp.append(three);
                one--;
                two--;
            }
            while (one>=0){
                int first=Integer.parseInt(currentResult.charAt(one)+"");
                int three=first+carry;
                carry=0;
                if (three>=10){
                    carry=three/10;
                    temp.append(three%10);
                }else
                    temp.append(three);
                one--;
            }
            while (two>=0){
                int second=Integer.parseInt(next.charAt(two)+"");
                int three=second+carry;
                carry=0;
                if (three>=10){
                    carry=three/10;
                    temp.append(three%10);
                }else
                    temp.append(three);
                two--;
            }
            if (carry!=0){
                temp.append(carry);
                carry=0;
            }
            currentResult=temp.reverse().toString();
        }
        if (minus){
            currentResult="-"+currentResult;
        }
        int index=0;
        while (index<(currentResult.length()-1)&&currentResult.charAt(index)=='0'){
            currentResult=currentResult.substring(1);
        }
        return currentResult;
    }
    public static void main(String args[]){
        System.out.print(MultiplyStrings.multiply("999", "999"));
    }
}
