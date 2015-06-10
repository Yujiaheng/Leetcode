/**
 * Created by JiahengYu on 29/05/15.
 */
public class reverseInteger {
    public static int reverse(int x) {
        long result=0;
        while (x!=0){
            if (result*10+x%10<=Integer.MIN_VALUE||result*10+x%10>=Integer.MAX_VALUE)
                return 0;
            else
                result=result*10+x%10;
            x=x/10;
        }
        return (int)result;
    }
    public static void main(String args[]){
        System.out.print(reverse(1534236469));
    }

}
