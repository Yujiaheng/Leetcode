/**
 * Created by JiahengYu on 10/06/15.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null||s.length()==0)
            return true;
        boolean palindrome=true;
        int start=0;
        int end=s.length()-1;
        while (start<=end&&(!Character.isAlphabetic(s.charAt(start))&&!Character.isDigit(start))){
            start++;
        }
        while (start<=end&&(!Character.isAlphabetic(s.charAt(end))&&!Character.isDigit(end))){
            end--;
        }
        while (start<=end){
            if (Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end)))
                return false;
            do{
                start++;
            }while (start<=end&&!Character.isAlphabetic(s.charAt(start))&&!Character.isDigit(start));
            do{
                end--;
            }while (start<=end&&!Character.isAlphabetic(s.charAt(end))&&!Character.isDigit(end));
        }
        return palindrome;
    }
}
