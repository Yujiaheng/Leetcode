import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 08/06/15.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List <String> result=new LinkedList<String>();
        if (s==null||s.length()<4)
            return result;
        manipulation("",s,4,result);
        return result;
    }
    public void manipulation(String first,String second,int k,List<String>result){
        if(k==0&&second.length()==0){
            first=first.substring(1);
            result.add(first);
            return;
        }else if (k==0&&second.length()!=0)
            return;
        for (int i=1;i<=second.length()&&i<=3;i++){
            String temp1=second.substring(0,i);
            if (Integer.parseInt(temp1)<=Integer.parseInt("255")){
                if (Integer.parseInt(temp1)==0&&temp1.length()!=1);
                else if ((temp1.length()>1&&temp1.startsWith("0")));
                else{
                    String copyFirst = first + "." + temp1;
                    String copySecond = second.substring(i);
                    int nextK = k - 1;
                    manipulation(copyFirst, copySecond, nextK, result);
                }
            }
        }
    }

    public static void main(String args[]){
        RestoreIPAddresses test=new RestoreIPAddresses();
        List<String> result=test.restoreIpAddresses("010010");
        for (String temp:result){
            System.out.println(temp);
        }
    }
}
