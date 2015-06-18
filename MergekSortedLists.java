/**
 * Created by JiahengYu on 18/06/15.
 */
public class MergekSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0)
            return null;
        if (lists.length==1)
            return lists[0];
        if (lists.length==2)
            return mergeList(lists,lists[0],lists[1]);
        return manipulation(lists,0,lists.length-1);
    }
    private ListNode manipulation(ListNode[]list, int first,int second){
        if (second-first==0)
            return list[first];
        else if (second-first==1)
            return mergeList(list,list[first],list[second]);
        else {
            int mid=(first+second)/2;
            ListNode one=manipulation(list,first,mid);
            ListNode two=manipulation(list,mid+1,second);
            return mergeList(list,one,two);
        }
    }

    private ListNode mergeList(ListNode[]lists,ListNode one,ListNode two){
        ListNode firstHead=one;
        ListNode secondHead=two;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode move=dummy;
        while (firstHead!=null&&secondHead!=null){
            if (firstHead.val>secondHead.val){
                move.next=secondHead;
                secondHead=secondHead.next;
            }else {
                move.next=firstHead;
                firstHead=firstHead.next;
            }
            move=move.next;
        }
        while (firstHead!=null){
            move.next=firstHead;
            firstHead=firstHead.next;
            move=move.next;
        }
        while (secondHead!=null){
            move.next=secondHead;
            secondHead=secondHead.next;
            move=move.next;
        }
        return dummy.next;
    }
}
