import java.util.Stack;

/**
 * Created by JiahengYu on 04/06/15.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m==1&&n==0)
            return 1;
        if (m==0&&n==1)
            return 1;
        if (m==0&&n>0)
            return uniquePaths(m,n-1);
        if (m>0&&n==0)
            return uniquePaths(m-1,n);
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }



    class Tuple{
        public int x;
        public int y;
        public Tuple(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int uniquePaths2(int m, int n){
        int counter=0;
        Stack<Tuple>stack=new Stack<Tuple>();
        Tuple first=new Tuple(m,n);
        stack.push(first);
        while (!stack.isEmpty()){
            Tuple temp=stack.pop();
            if (temp.x==1&&temp.y==1)
                counter++;
            else if (temp.x==1&&temp.y>1)
                stack.push(new Tuple(temp.x,temp.y-1));
            else if (temp.x>1&&temp.y==1)
                stack.push(new Tuple(temp.x-1,temp.y));
            else if (temp.x>1&&temp.y>1){
                stack.push(new Tuple(temp.x-1,temp.y));
                stack.push(new Tuple(temp.x,temp.y-1));
            }
        }
        return counter;
    }
    //dynamic programming
    public int uniquePaths3(int m, int n){
        if (m==0&&n==0)
            return 0;
        if (m==0)
            return 1;
        if (n==0)
            return 1;
        int dp[][]=new int[m][n];
        //dp[i][j]=dp[i-1][j]+dp[i][j-1]
        for (int i=0;i<n;i++)
            dp[0][i]=1;
        for (int j=0;j<m;j++)
            dp[j][0]=1;
        for (int i=1;i<m;i++)
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        return dp[m-1][n-1];
    }

    public static void main(String args[]){
        System.out.println(new UniquePaths().uniquePaths(2, 2));
        System.out.println(new UniquePaths().uniquePaths2(5,5));
        System.out.println(new UniquePaths().uniquePaths3(5,5));
    }
}
