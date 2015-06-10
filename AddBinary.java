/**
 * Created by JiahengYu on 04/06/15.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a==null||b==null)
            return null;
        if (a.equals(""))return b;
        if (b.equals(""))return a;
        StringBuffer stringBuffer=new StringBuffer();
        int length=a.length()<b.length()?a.length():b.length();
        int carry=0;
        int i=0;
        for (i=0;i<length;i++){
            int one=Integer.parseInt(a.charAt(a.length()-1-i)+"");
            int two=Integer.parseInt(b.charAt(b.length()-1-i)+"");
            int res=0;
            res=(one+two+carry)%2;
            carry=(one+two+carry)/2;
            stringBuffer.append(res);
        }
        if (i<a.length()){
            for (;i<a.length();i++){
                int one=Integer.parseInt(a.charAt(a.length()-1-i) + "");
                int res=0;
                res=(one+carry)%2;
                carry=(one+carry)/2;
                stringBuffer.append(res);
            }
        }

        if (i<b.length()){
            for (;i<b.length();i++){
                int one=Integer.parseInt(b.charAt(b.length()-1-i) + "");
                int res=0;
                res=(one+carry)%2;
                carry=(one+carry)/2;
                stringBuffer.append(res);
            }
        }

        if (carry!=0){
            stringBuffer.append(carry%2);
            carry=carry/2;
        }
        if (stringBuffer.toString().matches("[0]{1,}"))
            return "0";
        return stringBuffer.reverse().toString();
    }

    public static void main(String args[]){
        System.out.print(new AddBinary().addBinary("100","110010"));
    }
}
