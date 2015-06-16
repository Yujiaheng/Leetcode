/**
 * Created by JiahengYu on 15/06/15.
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s==null||s.length()==0)
            return "";
        String a[]=s.split(" ");
        if (a.length==0)
            return "";
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=a.length-1;i>=0;i--) {
            if (!a[i].equals("")) {
                stringBuffer.append(a[i]);
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.subSequence(0,stringBuffer.length()-1).toString();
    }

    public static void main(String args[]){
        System.out.print(new ReverseWordsinaString().reverseWords(" 1"));
    }
}
