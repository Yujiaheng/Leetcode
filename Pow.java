/**
 * Created by JiahengYu on 18/06/15.
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n>=0)
            return manipulation(x,n);
        else
            return 1/manipulation(x,-n);
    }

    private double manipulation(double x,int n){
        if (n==0)
            return 1;
        if (n==1)
            return x;
        double temp=manipulation(x,n/2);
        if(n%2==1)
            return temp*temp*x;
        else
            return temp*temp;
    }

    public static void main(String args[]){
        System.out.print(new Pow().myPow(2,-10));
    }
}
