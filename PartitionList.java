/**
 * Created by JiahengYu on 07/06/15.
 */
public class PartitionList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        ListNode copyHead=new ListNode(Integer.MIN_VALUE);
        ListNode pre=new ListNode(Integer.MIN_VALUE);
        pre.next=head;
        ListNode next=pre;
        ListNode current=copyHead;
        while (next.next!=null){
            if (next.next.val>=x){
                next=next.next;
            }else {
                ListNode temp=next.next;
                while (temp!=null&&temp.val<x) {
                    current.next = new ListNode(temp.val);
                    current = current.next;
                    temp=temp.next;
                }
                next.next=temp;
            }
        }
        while (head!=null&&head.val<x){
            head=head.next;
        }
        current.next=head;
        return copyHead.next;
    }


    public static void main(String args[]){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(2);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(2);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        PartitionList test=new PartitionList();
        test.partition(l1,3);
    }
}
