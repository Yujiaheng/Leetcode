/**
 * Created by JiahengYu on 16/06/15.
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int check=0;
        for (int i=0;i<32;i++){
            if ((n&1)>0)
                check++;
            n=n>>1;
        }
        return check;
    }

    public static void main(String args[]){
        System.out.print(new Numberof1Bits().hammingWeight(11));
    }
}
