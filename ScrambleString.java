/**
 * Created by JiahengYu on 07/06/15.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        char words[] = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            words[s1.charAt(i) - 'a']++;
            words[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i] != 0)
                return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;
            s21 = s2.substring(0, s2.length() - i);
            s22 = s2.substring(s2.length() - i, s2.length());
            if (isScramble(s11, s22) && isScramble(s12, s21))
                return true;
        }
        return false;
    }


    public boolean isScramble2(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        char words[] = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            words[s1.charAt(i) - 'a']++;
            words[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i] != 0)
                return false;
        }
        int length = s1.length();
        boolean dp[][][] = new boolean[length][length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = length - 1; j >= 0; j--) {
                for (int k = 1; k < length - Math.max(i, j); k++) {
                    if (s1.substring(i, i + k).equals(s2.substring(j, j + k)))
                        dp[i][j][k] = true;
                    else {
                        for (int l = 1; l < k; l++) {
                            if ((dp[i][j][l] && dp[i + l][j + l][k - l]) || (dp[i][j + k - l][l] && dp[i + l][j][k - l])) {
                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][length-1];
    }


    public static void main(String args[]){
        ScrambleString temp=new ScrambleString();
        System.out.println(temp.isScramble("great", "rgeat"));
        System.out.println(temp.isScramble2("great", "rgeat"));
    }
}
