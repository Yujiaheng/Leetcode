import java.util.Stack;

/**
 * Created by JiahengYu on 16/06/15.
 */
public class ReverseLinkedList2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
//    public ListNode reverseList(ListNode head) {
//        if (head==null||head.next==null)
//            return head;
//        Stack<ListNode> stack=new Stack<ListNode>();
//        ListNode move=head;
//        while (move!=null){
//            stack.push(move);
//            move=move.next;
//        }
//        head=stack.pop();
//        move=head;
//        while (!stack.isEmpty()){
//            move.next=stack.pop();
//            move=move.next;
//        }
//        return head;
//    }
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode previous=null;
        ListNode first=head;
        ListNode second=head.next;
        ListNode move=second.next;
        swap(first,second,previous);
        while (move!=null){
            previous=second;
            first=move;
            move=move.next;
            if(move==null){
                first.next=previous;
                return first;
            }else {
                second=move;
                move=move.next;
                swap(first,second,previous);
            }
        }
        return second;
    }
    private void swap(ListNode one,ListNode two,ListNode previous){
        two.next=one;
        one.next=previous;
    }

    public static void main(String args[]){
        ListNode t1=new ListNode(1);
        ListNode t2=new ListNode(2);
        ListNode t3=new ListNode(3);
        ListNode t4=new ListNode(4);
        ListNode t5=new ListNode(5);
        ListNode t6=new ListNode(6);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        t5.next=t6;
        ListNode result=new ReverseLinkedList2().reverseList(t1);
        while (result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
}
