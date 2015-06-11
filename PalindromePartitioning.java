import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 11/06/15.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new LinkedList<List<String>>();
        if (s==null||s.length()==0)
            return result;
        List<String>list=new LinkedList<String>();
        manipulaiton(s,list,result);
        return result;
    }
    public void manipulaiton(String current,List<String>list,List<List<String>> result){
        if (current.length()==0){
            result.add(list);
            return;
        }
        for (int length=1;length<=current.length();length++){
                String temp=current.substring(0,length);
                if (isPalindrome(temp)){
                    List<String>copyList=new LinkedList<String>(list);
                    copyList.add(temp);
                    manipulaiton(current.substring(length),copyList,result);
                }
        }
    }
    public boolean isPalindrome(String a){
        boolean palindrome=true;
        if (a==null)
            return false;
        if (a.length()==0)
            return palindrome;
        int start=0;
        int end=a.length()-1;
        while (start<end){
            if (a.charAt(start)!=a.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return palindrome;
    }

    public static void main(String args[]){
        PalindromePartitioning test=new PalindromePartitioning();
        test.partition("abbab");
    }
}
