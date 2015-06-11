/**
 * Created by JiahengYu on 11/06/15.
 */
public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head==null)
            return null;
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
                break;
        }
        if (fast==slow){
            ListNode slowTwo=head;
            while (slowTwo!=slow){
                slow=slow.next;
                slowTwo=slowTwo.next;
            }
            return slowTwo;
        }else {
            return null;
        }
    }
}
