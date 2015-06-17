import java.util.HashSet;

/**
 * Created by JiahengYu on 16/06/15.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n==1)
            return true;
        HashSet<Integer> hashSet=new HashSet<Integer>();
        hashSet.add(n);
        while (n!=1){
            int temp=0;
            while (n!=0){
                temp+=Math.pow(n%10,2);
                n/=10;
            }
            if (hashSet.contains(temp))
                return false;
            hashSet.add(temp);
            n=temp;
        }
        return true;
    }

    public static void main (String args[]){
        System.out.print(new HappyNumber().isHappy(2));
    }
}
