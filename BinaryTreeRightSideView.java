import java.util.Hashtable;

/**
 * Created by JiahengYu on 16/06/15.
 */
public class BinaryTreeRightSideView {
    public boolean isIsomorphic(String s, String t) {
        Hashtable<String, String> map = new Hashtable<String, String>();
        if (s == null || t == null || s.length() != t.length())
            return false;
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            String one = s.charAt(i) + "";
            String two = t.charAt(i) + "";
            if (map.keySet().contains(one)||map.values().contains(two)) {
                if (map.get(one) != null && !map.get(one).equals(two)) {
                    return false;
                }
                if (!map.keySet().contains(one)&&map.values().contains(two)){
                    return false;
                }else {
                    map.put(one, two);
                }
            } else {
                map.put(one, two);
            }
        }
        return true;
    }
    public static void main(String args[]){
        System.out.print(new BinaryTreeRightSideView().isIsomorphic("baa","cfa"));
    }
}
