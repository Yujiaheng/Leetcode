import java.util.List;

/**
 * Created by JiahengYu on 29/05/15.
 */
public class merge2Lists {
     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null)return null;
        if (l1==null)return l2;
        if (l2==null)return l1;
        ListNode head=new ListNode(-20);
        ListNode current=head;
        while(l1!=null&&l2!=null){
            if (l1.val>l2.val){
                current.next=l2;
                current=current.next;
                l2=l2.next;
            }else if (l1.val<l2.val){
                current.next=l1;
                current=current.next;
                l1=l1.next;
            }else {
                current.next=l1;
                current=l1;
                l1=l1.next;
                current.next=l2;
                current=current.next;
                l2=l2.next;
            }
        }
        while (l2!=null)
        {
            current.next=l2;
            current=l2;
            l2=l2.next;
        }
        while (l1!=null)
        {
            current.next=l1;
            current=l1;
            l1=l1.next;
        }

        current.next=null;
        return head.next;
    }
    public static void main(String[]args){
        ListNode head=mergeTwoLists(new ListNode(1),new ListNode(1));
        System.out.print(head==null);
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }
}
