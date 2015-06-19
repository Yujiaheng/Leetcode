import java.util.LinkedList;

/**
 * Created by JiahengYu on 19/06/15.
 */
public class ConvertSortedListtoBinarySearchTree {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return new TreeNode(head.val);
        TreeNode tree=manipulation(head);
        return tree;
    }
    private TreeNode manipulation(ListNode list){
        if (list==null)
            return null;
        if (list.next==null)
            return new TreeNode(list.val);
        ListNode slow=list;
        ListNode fast=list;
        ListNode previous=slow;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            previous=slow;
            slow=slow.next;
        }
        ListNode two=slow.next;
        ListNode one=list;
        slow.next=null;
        previous.next=null;
        TreeNode head=new TreeNode(slow.val);
        head.left=manipulation(one);
        head.right=manipulation(two);
        return head;
    }


    public static void main(String args[]){
//        ListNode t1=new ListNode(1);
//        ListNode t2=new ListNode(2);
//        ListNode t3=new ListNode(3);
//        ListNode t4=new ListNode(4);
//        ListNode t5=new ListNode(5);
//        ListNode t6=new ListNode(6);
//        t1.next=t2;
//        t2.next=t3;
//        t3.next=t4;
//        t4.next=t5;
//        t5.next=t6;
//        TreeNode node = new ConvertSortedListtoBinarySearchTree().sortedListToBST(t1);
    }
}
