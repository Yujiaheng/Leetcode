import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by JiahengYu on 02/06/15.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String>result=new LinkedList<String>();
        if (strs==null||strs.length==0)return result;
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        for (int i=0;i<strs.length;i++){
            if (strs[i].length()!=0) {
                char temp[] = strs[i].toCharArray();
                Arrays.sort(temp);
                if (map.containsKey(new String(temp))) {
                    ArrayList<String>one=map.get(new String(temp));
                    one.add(strs[i]);
                    map.replace(new String(temp),one);
                } else {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(strs[i]);
                    map.put(new String(temp), list);
                }
            }else {
                if (map.containsKey(strs[i])) {
                    ArrayList<String>one=map.get(new String(strs[i]));
                    one.add(strs[i]);
                    map.replace(new String(strs[i]), one);
                } else {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(strs[i]);
                    map.put(new String(strs[i]), list);
                }
            }
        }

        for (ArrayList a: map.values()){
            if (a.size()>1)
                result.addAll(a);
        }
        return result;
    }
    public static void main(String args[]){
        Anagrams a= new Anagrams();
        String test[]={"c","c"};
        a.anagrams(test);
    }
}
