/**
 * Created by JiahengYu on 03/06/15.
 */
public class RotateList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
            }
        }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode copyHead=head;
        ListNode fast=head;
        ListNode slow=head;
        if (head==null||k==0)return null;
        while (fast.next!=null)
            fast=fast.next;
        fast.next=head;
        fast=head;
        int index=0;
        int size=1;
        for (index=0;index<k&&fast!=null;index++){
            fast=fast.next;
            size++;
        }
        while (fast.next!=head){
            fast=fast.next;
            slow=slow.next;
        }
        if (slow==fast){
            return head;
        }
        head=slow.next;
        slow.next=null;
        fast.next=copyHead;
        return head;
    }
}
