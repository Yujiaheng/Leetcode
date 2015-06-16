/**
 * Created by JiahengYu on 15/06/15.
 */
public class FactorialTrailingZeroes {
    /**
     *count how many 5 s are there in the number
     */
    public int trailingZeroes(int n) {
        int result=0;
        int i=0;
        while (i*5<n){

            result++;
            i++;
        }
        return result;
    }

    public int trailingZeroes2(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i ++)
        {
            int tmp = i;
            while(tmp%5 == 0)
            {
                ret ++;
                tmp /= 5;
            }
        }
        return ret;
    }
    public int trailingZeroes3(int n){
        int ret=0;
        while (n>0){
            ret+=n/5;
            n=n/5;
        }
        return ret;
    }

    public static void main(String args[]){
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(25));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes2(25));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes3(25));
    }
}
