/**
 * Created by JiahengYu on 04/06/15.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        boolean minus=false;
        if (x==0)return 0;
        if (x<0)
            minus=true;
        int result=manipulation(Math.abs(x));
        if (minus)
            result=-result;
        return result;
    }
    public int manipulation(int x){
        int start=0;
        int end=x;
        while (end>=start){
            int middle=(start+end)/2;
            if (middle==x/middle){
                return middle;
            }else if (middle<x/middle){
                start=middle+1;
            }else if (middle>x/middle){
                end=middle-1;
            }
        }
        return end;
    }

    public static void main(String arg[]){
        Sqrtx test=new Sqrtx();
        System.out.print(test.mySqrt(2147395599));
    }
}
