/**
 * Created by JiahengYu on 30/05/15.
 */
public class ImplementStrStr {
    static int result=-1;
    public static int strStr(String haystack, String needle) {
        if(haystack==null||haystack.length()==0||needle==null||needle.length()==0)return 0;
        manipulation(haystack,needle,0,haystack.length());
        return result;
    }
    public static void manipulation(String haystack, String needle,int index,int length){
        if (haystack.length()==1){
            if (haystack.startsWith(needle))
                result=index;
            return;
        }
        else{
            if (haystack.startsWith(needle)){
                if (result>index||result<0)
                    result=index;
                return;
            }else {
                int a=index+1;
                manipulation(haystack.substring(1),needle,a,length);
            }
        }
    }

    public static int strStr2(String haystack, String needle) {
            if(haystack==null||needle==null)return 0;
            if(haystack.length()==0&&needle.length()==0) return 0;
            if(haystack.length()!=0&&needle.length()==0) return 0;
            if(haystack.length()==0&&needle.length()!=0) return -1;
            for (int i=0;i<haystack.length();i++){
                if (haystack.substring(i).startsWith(needle)){
                    return i;
                }
            }
            return -1;
        }

    public static void main(String args[]){
       System.out.print(ImplementStrStr.strStr("abcd", "abd"));
    }
}
