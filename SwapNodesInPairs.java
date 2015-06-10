import java.util.Stack;

/**
 * Created by JiahengYu on 30/05/15.
 */
public class SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head==null)return null;
        ListNode fast=head;
        if (head.next==null)return head;
        ListNode newHead=head.next;
        Stack <ListNode> stack=new Stack<ListNode>();
        stack.push(fast);
        ListNode slow=new ListNode(000);
        slow.next=head;
        fast=fast.next;
        while (fast!=null){
            if (stack.size()<2) {
                stack.push(fast);
                fast = fast.next;
            }else {
                ListNode one = stack.pop();
                ListNode two = stack.pop();
                fast = one.next;
                one.next=two;
                two.next=fast;
                slow.next=one;
                slow = two;
            }
        }
        while (!stack.isEmpty()){
            ListNode one = stack.pop();
            slow.next=one;
            slow = one;
        }
        slow.next=null;
        return newHead;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(1);
        ListNode two=new ListNode(2);
        ListNode three=new ListNode(3);
        ListNode four=new ListNode(4);
        one.next=two;
//        two.next=three;
//        three.next=four;
        ListNode result=new SwapNodesInPairs().swapPairs(one);
        while (result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
}
