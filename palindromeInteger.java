/**
 * Created by JiahengYu on 29/05/15.
 */
public class palindromeInteger {
    public boolean isPalindrome(int x) {
        int result=0;
        int y=x;
        while (x!=0){
            result=result*10+x%10;
            x/=10;
        }
        return Math.abs(y)==result;
    }
}
