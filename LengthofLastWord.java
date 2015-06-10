/**
 * Created by JiahengYu on 03/06/15.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s==null||s.length()==0)
            return 0;
        int result=0;
        int index=s.length()-1;
        while (index>=0&&s.charAt(index)==' '){
            index--;
        }
        if (index<0)
            return 0;
        while (index>=0&&s.charAt(index)!=' '){
            result++;
            index--;
        }
        return result;
    }
    public static void main(String args[]){
        LengthofLastWord test=new LengthofLastWord();
        System.out.print(test.lengthOfLastWord("a"));
    }
}
