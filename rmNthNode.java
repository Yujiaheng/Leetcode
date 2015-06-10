/**
 * Created by JiahengYu on 29/05/15.
 */
public class rmNthNode {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)return null;
        ListNode first=head;
        ListNode second=head;
        int numberOfNodes=0;
        while(n>0)
        {
            n--;
            second=second.next;
        }
        if (second==null)return head.next;
        while(second.next!=null){
            second=second.next;
            first=first.next;
        }
        first.next=first.next.next;
        return head;
    }
}
