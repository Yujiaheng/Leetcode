import java.util.List;

/**
 * Created by JiahengYu on 15/06/15.
 */
public class SortList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * merge Sort
     */
//    public ListNode sortList(ListNode head) {
//        if (head==null||head.next==null)
//            return head;
//        ListNode dummy=new ListNode(Integer.MIN_VALUE);
//        dummy.next=head;
//        ListNode h1=dummy;
//        ListNode h2=dummy;
//        while (h2!=null&&h2.next!=null){
//            h1=h1.next;
//            h2=h2.next.next;
//        }
//        h2=h1.next;
//        h1.next=null;
//        h1=head;
//
//        return merge(sortList(h1),sortList(h2));
//    }
//
//    private ListNode merge(ListNode l1,ListNode l2){
//        if (l1==null)return l2;
//        if (l2==null)return l1;
//
//        ListNode result=new ListNode(Integer.MIN_VALUE);
//        ListNode curNode=result;
//        while (l1!=null&&l2!=null){
//            if (l1.val>l2.val){
//                curNode.next=l2;
//                l2=l2.next;
//            }else {
//                curNode.next=l1;
//                l1=l1.next;
//            }
//            curNode=curNode.next;
//        }
//        if (l1!=null)curNode.next=l1;
//        if (l2!=null)curNode.next=l2;
//
//        return result.next;
//    }

    /**
     * merge sort
     */
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        slow=head;

        return merge(sortList(slow),sortList(fast));
    }

    private ListNode merge(ListNode s1,ListNode s2){
        if (s1==null)return s2;
        if (s2==null)return s1;
        ListNode result=new ListNode(Integer.MIN_VALUE);
        ListNode newHead=result;
        ListNode l1=s1;
        ListNode l2=s2;

        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                result.next=l1;
                l1=l1.next;
            }else {
                result.next=l2;
                l2=l2.next;
            }
            result=result.next;
        }
        if (l1!=null)result.next=l1;
        if (l2!=null)result.next=l2;

        return newHead.next;
    }
}
