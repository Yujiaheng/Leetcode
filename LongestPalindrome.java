/**
 * Created by JiahengYu on 29/05/15.
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int maxLength=1;
        int resultStartIndex=0;
        int n=s.length();
        int d[][]=new int[n][n];
        for (int i=0;i<n;i++)
            d[i][i]=1;
        for (int i=0;i<n-1;i++){
            if (s.charAt(i)==s.charAt(i+1)) {
                resultStartIndex=i;
                d[i][i + 1] = 1;
                maxLength=2;
            }
        }
        for (int length=3;length<=n;length++){
            for (int i=0;i<=n-length;i++){
                int j=i+length-1;
                if (s.charAt(i)==s.charAt(j)&&d[i+1][j-1]==1){
                    d[i][j]=1;
                    int currentLength=j-i+1;
                    if (currentLength>maxLength) {
                        maxLength=currentLength;
                        resultStartIndex=i;
                    }
                }
            }
        }
        return s.substring(resultStartIndex,resultStartIndex+maxLength);
    }
    public static void main(String args[]){
        String s=LongestPalindrome.longestPalindrome("bacab");
        System.out.print(s);
    }
}
