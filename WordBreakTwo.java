import jdk.internal.dynalink.linker.LinkerServices;

import java.util.*;

/**
 * Created by JiahengYu on 31/05/15.
 */

/**
 * it works I think but time limits cannot be satisfied
 */
public class WordBreakTwo {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result=new LinkedList<String>();
        mainipulation(s,wordDict,result,"");
        return result;
    }
    public void mainipulation(String s, Set<String> wordDict,List<String> list, String first){
        if (s.length()==0)
            return;
        if (wordDict.contains(s)) {
            list.add(new String(first+" "+s).trim());
            return;
        }
        for (int i=1;i<=s.length();i++){
            String temp=s.substring(0,i);
            if (wordDict.contains(temp)){
                String previous=first+" "+temp;
                mainipulation(s.substring(i),wordDict,list,previous);
            }
        }
    }




    public List<String> wordBreak2(String s, Set<String> wordDict) {
        if (s==null||wordDict==null)return null;
        List<String> result=new LinkedList<String>();
        if (wordDict.size()==0)return result;
        if (s.length()==1) {
            if (wordDict.contains(s)) {
                result.add(s);
                return result;
            }else {
                return result;
            }
        }
        boolean dp[][]=new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            if (wordDict.contains(s.substring(i,i+1))){
                dp[i][i]=true;
            }
        }
        for (int i=0;i<s.length()-1;i++){
            if (wordDict.contains(s.substring(i,i+2)))
                dp[i][i+1]=true;
            else if (dp[i][i]&&dp[i+1][i+1])
                dp[i][i+1]=true;
        }

        for (int i=2;i<s.length();i++){
            for (int j=0;j<s.length()-i;j++){
                int start=j;
                int end=j+i;
                for (int first=start;first<end;first++){
                    if (dp[start][first]&&dp[first+1][end]){
                        dp[start][end]=true;
                        break;
                    }
                }
                if (!dp[start][end]) {
                    String temp=s.substring(start,end+1);
                    if (wordDict.contains(temp))
                        dp[start][end] = true;
                }
            }
        }
        if (!dp[0][s.length()-1]) {
            return result;
        }
        else {
            ArrayList<String>list=new ArrayList<String>();
            mainipulation2(s, 0, dp, s.length(), "", result,wordDict);
        }
        return result;
    }

    public void mainipulation2(String originalString, int start, boolean dp[][],int length, String tempResult, List<String> result, Set<String> wordDict){
        if (start>=length){
            result.add(tempResult.trim());
            return;
        }
        ArrayList<String> array=new ArrayList<String>();
        for (int first=start;first<length;first++){
            if (dp[start][first]) {
                if (wordDict.contains(originalString.substring(start,first+1))) {
                    String currentResult=tempResult+originalString.substring(start, first + 1)+" ";
                    mainipulation2(originalString, first + 1, dp, length, currentResult, result, wordDict);
                }
            }
        }
    }

    public static void main(String args[]){
        String s="catsanddog";
        WordBreakTwo wordbreak=new WordBreakTwo();
        Set<String>set=new HashSet<String>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        List<String>list=wordbreak.wordBreak2(s, set);
        System.out.print(list.size());
        for (String string:list){
            System.out.println(string);
        }
    }
}
