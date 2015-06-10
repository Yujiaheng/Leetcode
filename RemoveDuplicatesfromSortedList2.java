/**
 * Created by JiahengYu on 07/06/15.
 */
public class RemoveDuplicatesfromSortedList2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        if (head.next==null)
            return head;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode next = head.next;
        boolean dup = false;
        while (next!=null){
            if (cur.val!=next.val){
                if (dup){
                    pre=next;
                    dup=false;
                }else {
                    pre=cur;
                }
                cur=next;
                next=next.next;
            }else if (cur.val==next.val){
                dup=true;
                next=next.next;
            }
        }
        if (dup){
            pre.next=null;
        }
        return dummyHead.next;
    }
}
