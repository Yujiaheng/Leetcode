import java.util.ArrayList;

/**
 * Created by JiahengYu on 03/06/15.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuffer stringBuffer=new StringBuffer();
        if (k<0||n<0)return stringBuffer.toString();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        for (int i=1;i<=n;i++){
            arrayList.add(i);
        }
        k=k-1;
        while (n-1>=0){
            int index=k/factorial(n-1);
            stringBuffer.append(arrayList.get(index));
            arrayList.remove(index);
            k=k%factorial(n-1);
            n=n-1;
        }
        return stringBuffer.toString();
    }
    public int factorial(int n){
        if (n==0)
            return 1;
        else
            return n*factorial(n-1);
    }

    public static void main(String args[]){
        PermutationSequence test=new PermutationSequence();
        System.out.print(test.getPermutation(3, 1));
    }

}
