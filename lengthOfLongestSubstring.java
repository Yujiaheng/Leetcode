import java.util.HashSet;

/**
 * Created by JiahengYu on 28/05/15.
 */
public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int length=1;
        if(s==null)return 0;
        if(s.length()==0)return 0;
        if(s.length()==1)return 1;
        int start=0;
        int end=0;
        HashSet<Character> set=new HashSet<Character>();
        for (end=0;end<s.length();end++){
            char current=s.charAt(end);
            if (set.contains(current)){
                int currentLength=end-start;
                length=length>currentLength?length:currentLength;
                while (s.charAt(start)!=current){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }else {
                set.add(current);
            }
        }
        int currentlength=(end-start);
        length=length>currentlength?length:currentlength;
        //System.out.print(start);
        return length;
    }
    public static void main(String args[]){
        System.out.print(lengthOfLongestSubstring("tmmzuxt"));
    }
}
