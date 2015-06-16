/**
 * Created by JiahengYu on 15/06/15.
 */
public class IntersectionofTwoLinkedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null && headB==null)
            return null;
        if (headA==null || headB==null)
            return null;
        int lengthA=0;
        int lengthB=0;

        ListNode A=headA;
        ListNode B=headB;

        while (A!=null){
            A=A.next;
            lengthA++;
        }
        while (B!=null){
            B=B.next;
            lengthB++;
        }

        int diff=lengthA-lengthB;
        A=headA;
        B=headB;

        if (diff<0){
            for (int i=0;i<Math.abs(diff);i++){
                B=B.next;
            }
        }else {
            for (int i=0;i<Math.abs(diff);i++){
                A=A.next;
            }
        }

        while (A!=null&&B!=null&&A.val!=B.val){
            A=A.next;
            B=B.next;
        }

        if (A==null||B==null)
            return null;
        else
            return A;
    }
}
