/**
 * Created by JiahengYu on 01/06/15.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean result=true;
        //for each row
        for (int i=0;i<board.length;i++){
            boolean temp[]=new boolean[board[0].length];
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]!='.'){
                    int aNumber=board[i][j];
                    if (temp[aNumber-1])
                        return false;
                }
            }
        }
        //for each column
        for (int i=0;i<board.length;i++){
            boolean temp[]=new boolean[board[0].length];
            for (int j=0;j<board[0].length;j++){
                if (board[j][i]!='.'){
                    int aNumber=board[j][i];
                    if (temp[aNumber-1])
                        return false;
                    else
                        temp[aNumber-1]=true;
                }
            }
        }
        //for each small block

        for(int block=0;block<9;block++){
            boolean []map=new boolean[9];
            for (int i=block/3*3;i<block/3*3+3;i++){
                for (int j=block%3*3;j<block%3*3+3;j++){
                    if (board[i][j]!='.'){
                        if (map[(int)(board[i][j]-'1')])
                            return false;
                        map[(int)(board[i][j]-'1')]=true;
                    }
                }
            }
        }

        return result;
    }
}
