import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class MinStack {

    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    ArrayList<Integer> minValue = new ArrayList<Integer>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        arrayList.add(x);
        if (minValue.isEmpty()){
            min=x;
        }
        else{
            if (min > x)
                min = x;
        }
        minValue.add(min);
    }

    public void pop() {
        if (arrayList.size() == 0) {
            return;
        }
       // System.out.println(arrayList.get(arrayList.size() - 1));
        arrayList.remove(arrayList.size() - 1);
        minValue.remove(minValue.size() - 1);
    }

    public int top() {
        System.out.println(arrayList.get(arrayList.size() - 1));
        return arrayList.get(arrayList.size() - 1);
    }

    public int getMin() {
        if (minValue.size() == 0)
            return 0;
        System.out.println(minValue.get(minValue.size() - 1));
        return minValue.get(minValue.size() - 1);
    }


    public static void main(String args[]){
        MinStack test=new MinStack();
        test.push(2147483646);
        test.push(2147483646);
        test.push(2147483647);
        test.top();
        test.pop();
        test.getMin();
        test.pop();
        test.getMin();
        test.pop();
        test.push(2147483647);
        test.top();
        test.getMin();
        test.push(-2147483648);
        test.top();
        test.getMin();
        test.pop();
        test.getMin();
    }
}
