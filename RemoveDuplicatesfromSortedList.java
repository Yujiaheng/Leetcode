
/**
 * Created by JiahengYu on 07/06/15.
 */
public class RemoveDuplicatesfromSortedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        ListNode slow=head;
        int currentValue=slow.val;
        ListNode fast=head.next;
        while (fast.next!=null){
            if (fast.val!=currentValue){
                if (slow.next!=fast)
                    slow.next=fast;
                currentValue=fast.val;
                fast=fast.next;
                slow=slow.next;
            }else {
                fast=fast.next;
            }
        }
        if (slow.val==fast.val)
            slow.next=null;
        else
            slow.next=fast;
        return head;
    }

    public static void main(String args[]){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(2);
        l1.next=l2;
        l2.next=l3;
        RemoveDuplicatesfromSortedList test=new RemoveDuplicatesfromSortedList();
        test.deleteDuplicates(l1);
    }
}
