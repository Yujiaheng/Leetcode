import java.util.Stack;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        Stack<Integer> stack=new Stack<Integer>();
        while (n!=0){
            stack.push(n%2);
            n=n/2;
        }
        while (stack.size()<32){
            stack.push(0);
        }
        int i=0;
        int result=0;
        while (!stack.isEmpty()){
            int temp=stack.pop();
            result+=Math.pow(2,i)*temp;
            i++;
        }
        return result;
    }
    public static void main(String args[]){
        System.out.print(new ReverseBits().reverseBits(43261596));
    }
}
