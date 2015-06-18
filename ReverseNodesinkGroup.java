import jdk.nashorn.internal.ir.WhileNode;

import java.util.Stack;

/**
 * Created by JiahengYu on 18/06/15.
 */
public class ReverseNodesinkGroup {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null)
            return null;
        int length=0;
        ListNode move=head;
        while (move!=null){
            length++;
            move=move.next;
        }
        if (length/k==0)
            return head;
        else {
            Stack<ListNode>stack=new Stack<ListNode>();
            int time=length/k;
            ListNode dummy=new ListNode(Integer.MIN_VALUE);
            move=head;
            dummy.next=head;
            ListNode previous=dummy;
            while (time>0){
                int left=k;
                while (left>0){
                    stack.push(move);
                    move=move.next;
                    left--;
                }
                while (!stack.isEmpty()){
                    previous.next=stack.pop();
                    previous=previous.next;
                }
                time--;
            }
            previous.next=move;
            return dummy.next;
        }
    }


    public static void main(String args[]){
        ListNode t1=new ListNode(1);
        ListNode t2=new ListNode(2);
        ListNode t3=new ListNode(3);
        ListNode t4=new ListNode(4);
        ListNode t5=new ListNode(5);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        ListNode result=new ReverseNodesinkGroup().reverseKGroup(t1,3);
        while (result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
}
