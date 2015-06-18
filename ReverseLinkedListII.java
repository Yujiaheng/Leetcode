import java.util.Stack;

/**
 * Created by JiahengYu on 18/06/15.
 */
public class ReverseLinkedListII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null||head.next==null)
            return head;
        if (m==n)
            return head;
        ListNode dummyHead=new ListNode(Integer.MIN_VALUE);
        dummyHead.next=head;
        ListNode move=head;
        Stack<ListNode>stack=new Stack<ListNode>();
        int i=1;
        ListNode previous=dummyHead;
        ListNode next=null;
        while (i<=n){
            if (i+1==m){
                previous=move;
            }
            if (i>=m){
                stack.push(move);
            }
            if (i==n){
                next=move.next;
            }
            i++;
            move=move.next;
        }
        while (!stack.isEmpty()){
            ListNode temp=stack.pop();
            previous.next=temp;
            previous=previous.next;
        }
        previous.next=next;
        return dummyHead.next;
    }

    public static void main(String args[]){
        ListNode t1=new ListNode(1);
        ListNode t2=new ListNode(2);
//        ListNode t3=new ListNode(3);
//        ListNode t4=new ListNode(4);
//        ListNode t5=new ListNode(5);
        t1.next=t2;
//        t2.next=t3;
//        t3.next=t4;
//        t4.next=t5;
        ListNode result=new ReverseLinkedListII().reverseBetween(t1,1,2);
        while (result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
}
