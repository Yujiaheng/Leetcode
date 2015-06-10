/**
 * Created by JiahengYu on 01/06/15.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuffer stringBuffer=new StringBuffer();
        if (n==1)return "1";
        mainipulation(n-1-1,"1",stringBuffer);
        return stringBuffer.toString();
    }
    void mainipulation(int n,String previous,StringBuffer buffer){
        StringBuffer currentString=new StringBuffer();
        Character currentChar=previous.charAt(0);
        int currentCount=1;
        for (int i=1;i<previous.length();i++){
            if (previous.charAt(i)==currentChar){
                currentCount++;
            }else{
                currentString.append(currentCount);
                currentString.append(currentChar);
                currentChar=previous.charAt(i);
                currentCount=1;
            }
        }
        currentString.append(currentCount);
        currentString.append(currentChar);
        if (n==0){
            buffer.append(currentString.toString());
            return;
        }else{
            mainipulation(n-1,currentString.toString(),buffer);
        }
    }
    public static void main(String args[]){
        String aString=new CountAndSay().countAndSay(5);
        System.out.print(aString);
    }
}
