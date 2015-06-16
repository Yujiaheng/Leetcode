import java.util.List;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class InsertionSortList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode move=head;
        ListNode newHead=new ListNode(Integer.MIN_VALUE);
        newHead.next=head;
        ListNode current=newHead.next;
        ListNode currentPosition=move;
        while (current.next!=null){
            int currentMinValue=Integer.MAX_VALUE;
            move=current;
            while (move!=null){
                if (move.val<currentMinValue){
                    currentMinValue=move.val;
                    currentPosition=move;
                }
                move=move.next;
            }
            int temp=current.val;
            current.val=currentMinValue;
            currentPosition.val=temp;
            current=current.next;
        }
        return newHead.next;
    }


    public static void main(String args[]){
        ListNode t1=new ListNode(5);
        ListNode t2=new ListNode(4);
        ListNode t3=new ListNode(3);
        ListNode t4=new ListNode(2);
        ListNode t5=new ListNode(1);
        ListNode t6=new ListNode(9);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        t5.next=t6;
        ListNode test=new InsertionSortList().insertionSortList(t1);
        while (test!=null){
            System.out.print(test.val);
            test=test.next;
        }
    }
}
