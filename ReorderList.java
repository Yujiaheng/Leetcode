import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by JiahengYu on 11/06/15.
 */
public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        if (head==null)
            return;
        Stack<ListNode> stack=new Stack<ListNode>();
        Queue<ListNode> queue=new ConcurrentLinkedQueue<ListNode>();
        ListNode move=head;
        while (move!=null){
            stack.push(move);
            queue.add(move);
            move=move.next;
        }
        ListNode current=new ListNode(Integer.MIN_VALUE);
        int start=0;
        int end=stack.size()-1;
        while (start<end){
            start++;
            end--;
            ListNode que=queue.poll();
            ListNode sta=stack.pop();
            current.next=que;
            que.next=sta;
            current=sta;
        }
        if (start==end){
            current.next=queue.poll();
            current=current.next;
        }
        current.next=null;
    }
    public static void main(String args[]){
        ListNode t1=new ListNode(1);
        ListNode t2=new ListNode(2);
        ListNode t3=new ListNode(3);
        ListNode t4=new ListNode(4);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        new ReorderList().reorderList(t1);
        ListNode move=t1;
        while (move!=null){
            System.out.print(move.val);
            move=move.next;
        }
    }


}
