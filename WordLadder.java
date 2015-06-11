import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JiahengYu on 10/06/15.
 */
public class WordLadder {
//    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
//        HashMap<String,ArrayList<String>> graph=new HashMap<String, ArrayList<String>>();
//        graph.put(beginWord,new ArrayList<String>());
//        graph.put(endWord,new ArrayList<String>());
//        for (String s:wordDict)
//            graph.put(s,new ArrayList<String>());
//        for (String key: graph.keySet()){
//            ArrayList<String> nextOne=graph.get(key);
//            for (String key2:graph.keySet()){
//                if (distance(key,key2)==1)
//                    nextOne.add(key2);
//            }
//        }
//
//        int step=0;
//        ArrayList<String> firstLevel=new ArrayList<String>(graph.get(beginWord));
//        HashSet<String> visited=new HashSet<String>();
//        while (!firstLevel.isEmpty()){
//            step++;
//            if (firstLevel.contains(endWord))
//                return step+1;
//            else {
//                ArrayList<String> nextLevel=new ArrayList<String>();
//                for (String nextStep:firstLevel){
//                    nextLevel.addAll(graph.get(nextStep));
//                }
//                firstLevel.clear();
//                for (String currentLevel:nextLevel){
//                    if (!visited.contains(currentLevel)) {
//                        visited.add(currentLevel);
//                        firstLevel.add(currentLevel);
//                    }
//                }
//                nextLevel.clear();
//            }
//        }
//        System.out.print("hrere");
//        return 0;
//    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        HashMap<String,ArrayList<String>> graph=new HashMap<String, ArrayList<String>>();
        graph.put(beginWord,new ArrayList<String>());
        graph.put(endWord,new ArrayList<String>());
        wordDict.add(beginWord);
        wordDict.add(endWord);
        for (String key: wordDict){
            ArrayList<String> nextOne=new ArrayList<String>();
            for (String key2:wordDict) {
                if (!key.equals(key2)) {
                    if (distance(key, key2) == 1)
                        nextOne.add(key2);
                }
            }
            graph.put(key,nextOne);
        }

        int step=0;
        ArrayList<String> firstLevel=new ArrayList<String>(graph.get(beginWord));
        HashSet<String> visited=new HashSet<String>();
        visited.add(beginWord);
        while (!firstLevel.isEmpty()){
            step++;
            if (firstLevel.contains(endWord))
                return step+1;
            else {
                ArrayList<String> nextLevel=new ArrayList<String>();
                for (String nextStep:firstLevel){
                    if (!visited.contains(nextStep)) {
                        visited.add(nextStep);
                        nextLevel.addAll(graph.get(nextStep));
                    }
                }
                firstLevel.clear();
                if (nextLevel.contains(endWord)) {
                    return step + 2;
                }
                step++;
                for (String currentLevel:nextLevel){
                    if (!visited.contains(currentLevel)) {
                        visited.add(currentLevel);
                        firstLevel.addAll(graph.get(currentLevel));
                    }
                }
                nextLevel.clear();
            }
        }
        return 0;
    }



    private int distance(String s1,String s2){
        int distance=0;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i)!=s2.charAt(i)) {
                distance++;
                if (distance > 1)
                    return 0;
            }
        }
        return distance;
    }


    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        String[] strDict = {"hot","dot","dog","lot","log"};
        for (String s : strDict) {
            dict.add(s);
        }
        String start = "hit";
        String end = "cog";
        WordLadder solution = new WordLadder();
        System.out.println(solution.ladderLength(start, end, dict));
    }
}
