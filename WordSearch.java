import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JiahengYu on 05/06/15.
 *
 * [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 */
public class WordSearch {


    /**
     * 有错，没有纪录点的访问情况
     * 所有的点都职能访问一次
     */
    class Tuple{
        int x;
        int y;
        public Tuple(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static boolean result=false;
    public boolean exist(char[][] board, String word) {
        if(word==null||word.length()==0||board==null||board.length==0)
            return false;
        List<Tuple> list= new ArrayList<Tuple>();
        for (int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    list.clear();
                    list.add(new Tuple(i,j));
                    manipulation(board, word.substring(1), i, j,list);
                }
                if (result)
                    break;
            }
            if (result)
                break;
        }

        return result;
    }
    public void manipulation(char[][]board,String word,int currentRow,int currentColumn,List<Tuple> path){
        if (word.equals("")){
            result=true;
            return;
        }
        if (currentColumn+1<board[0].length&&board[currentRow][currentColumn+1]==word.charAt(0)&&!path.contains(new Tuple(currentRow,currentColumn+1))) {
                int nextcolumn=currentColumn+1;
                List<Tuple> copy= new ArrayList<Tuple>();
                copy.addAll(path);
                copy.add(new Tuple(currentRow,currentColumn+1));
                manipulation(board, word.substring(1), currentRow, nextcolumn, copy);
                if (result)
                return;
        }
        if (currentColumn-1>=0&&board[currentRow][currentColumn-1]==word.charAt(0)&&!path.contains(new Tuple(currentRow,currentColumn-1))) {
                int nextcolumn=currentColumn-1;
                List<Tuple> copy= new ArrayList<Tuple>();
                copy.addAll(path);
                copy.add(new Tuple(currentRow,currentColumn-1));
                manipulation(board, word.substring(1), currentRow, nextcolumn,copy);
            if (result)
                return;
        }

        if (currentRow+1<board.length&&board[currentRow+1][currentColumn]==word.charAt(0)&&!path.contains(new Tuple(currentRow+1,currentColumn))) {
                int nextRow=currentRow+1;
                List<Tuple> copy= new ArrayList<Tuple>();
                copy.addAll(path);
                copy.add(new Tuple(currentRow+1,currentColumn));
                manipulation(board, word.substring(1), nextRow, currentColumn, copy);
            if (result)
                return;
        }
        if (currentRow-1>=0&&board[currentRow-1][currentColumn]==word.charAt(0)&&!path.contains(new Tuple(currentRow-1,currentColumn))) {
                int nextRow=currentRow-1;
                List<Tuple> copy= new ArrayList<Tuple>();
                copy.addAll(path);
                copy.add(new Tuple(currentRow-1,currentColumn));
                manipulation(board, word.substring(1), nextRow, currentColumn,copy);
            if (result)
                return;
        }
    }


    public static void main(String args[]){
        char[][] data={{'a'}};
        WordSearch test=new WordSearch();
        System.out.print(test.exist(data, "ab"));
        //System.out.print("a".substring(2));
    }
}
