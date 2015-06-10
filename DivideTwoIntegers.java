/**
 * Created by JiahengYu on 30/05/15.
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        boolean minus=false;
        if (dividend-dividend>dividend)
            minus=true;
        int result=0;
        int i=0;
        int temp=0;
        while(temp<dividend){
            temp+=divisor;
            i++;
        }
        if (minus)
            return 1-i;
        return i-1;
    }
    public static void main(String args[]){
        System.out.print(new String("a").substring(1)==null);
    }
}
