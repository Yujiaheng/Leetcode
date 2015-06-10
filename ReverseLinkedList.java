/**
 * Created by JiahengYu on 08/06/15.
 */
public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode CopyHead=head;
        ListNode slow=head;
        ListNode fast=head;
        for (int i=0;i<n;i++){
            if (i<m)
                slow=slow.next;
        }
        return head;
    }
}
