/**
 * Created by JiahengYu on 10/06/15.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1==null&&word2==null)
            return 0;
        if ((word1==null||word1.length()==0)&&word2!=null)
            return word2.length();
        if ((word2==null||word2.length()==0)&&word1!=null)
            return word1.length();

        int dp[][]=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;
        for (int i=1;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for (int j=1;j<=word2.length();j++){
            dp[0][j]=j;
        }
        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                char ch1=word1.charAt(i-1);
                char ch2=word2.charAt(j-1);
                if (ch1==ch2)
                    dp[i][j]=dp[i-1][j-1];
                else {
                    int replace=dp[i-1][j-1];
                    int deleteS1=dp[i-1][j];
                    int insertS1=dp[i][j-1];
                    int temp=Math.min(replace,deleteS1);
                    dp[i][j]=Math.min(temp,insertS1)+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String args[]){
        EditDistance test=new EditDistance();
        System.out.print(test.minDistance("a","b"));
    }
}
