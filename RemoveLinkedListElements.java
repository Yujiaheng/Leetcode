/**
 * Created by JiahengYu on 16/06/15.
 */
public class RemoveLinkedListElements {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return null;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode move=dummy;
        while (move!=null&&move.next!=null){
            if (move.next.val==val){
                move.next=move.next.next;
            }else {
                move=move.next;
            }
        }
        return dummy.next;
    }

    public static void main(String args[]){
        ListNode t1=new ListNode(1);
        ListNode t2=new ListNode(1);
        ListNode t3=new ListNode(1);
        t1.next=t2;
        t2.next=t3;
        new RemoveLinkedListElements().removeElements(t1,1);
    }
}
