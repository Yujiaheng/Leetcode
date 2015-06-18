import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by JiahengYu on 18/06/15.
 */
public class ImplementStackusingQueues {
    Queue<Integer>one =new ConcurrentLinkedQueue<Integer>();
    Queue<Integer>two =new ConcurrentLinkedQueue<Integer>();
    public void push(int x) {
        if (one.isEmpty()&&two.isEmpty()){
            one.add(x);
        }else if (!one.isEmpty()){
            one.add(x);
        }else
            two.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (one.isEmpty()&&two.isEmpty()){
            return;
        }if (!one.isEmpty()){
            while (one.size()>0&&one.size()!=1){
                two.add(one.poll());
            }
            one.clear();
        }else {
            while (two.size()>0&&two.size()!=1){
                one.add(two.poll());
            }
            two.clear();
        }
    }

    // Get the top element.
    public int top() {
        if (one.isEmpty()&&two.isEmpty()){
            return 0;
        }if (!one.isEmpty()){
            while (one.size()>0&&one.size()!=1){
                two.add(one.poll());
            }
            int result=one.poll();
            two.add(result);
            return result;
        }else {
            while (two.size()>0&&two.size()!=1){
                one.add(two.poll());
            }
            int result=two.poll();
            one.add(result);
            return result;
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if (one.isEmpty()&&two.isEmpty())
            return true;
        return false;
    }
}
