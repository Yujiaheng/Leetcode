import java.util.HashSet;
import java.util.Set;

/**
 * Created by JiahengYu on 30/05/15.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        if (s==null||s.length()==0)return false;
        boolean result=false;
        boolean d[][]=new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            if (wordDict.contains(s.substring(i,i+1))){
                d[i][i]=true;
            }
        }
        for (int i=0;i<s.length()-1;i++){
            if (wordDict.contains(s.substring(i,i+2)))
                d[i][i+1]=true;
            else if (d[i][i]&&d[i+1][i+1])
                d[i][i+1]=true;
        }

        for (int i=2;i<s.length();i++){
            for (int j=0;j<s.length()-i;j++){
                int start=j;
                int end=j+i;
                for (int first=start;first<end;first++){
                    if (d[start][first]&&d[first+1][end]){
                        d[start][end]=true;
                        break;
                    }
                }
                if (!d[start][end]) {
                    String temp=s.substring(start,end+1);
                    if (wordDict.contains(temp))
                        d[start][end] = true;
                }
            }
        }
        return d[0][s.length()-1];
    }
    public static void main(String args[]){
        Set<String> set = new HashSet<String>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        boolean result=WordBreak.wordBreak("catsanddog",set);
        System.out.print(result);
    }
}
