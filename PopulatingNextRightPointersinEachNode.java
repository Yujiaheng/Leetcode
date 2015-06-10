/**
 * Created by JiahengYu on 09/06/15.
 */
public class PopulatingNextRightPointersinEachNode {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if (root==null)
            return;
        manipulation(root);
    }
    public void manipulation(TreeLinkNode root){
        if (root==null)
            return;
        if (root.left==null)
            return;
        TreeLinkNode move=root;
        while (move.next!=null){
            TreeLinkNode nextRelative=move.next;
            move.left.next=move.right;
            move.right.next=nextRelative.left;
            nextRelative.left.next=nextRelative.right;
            move=nextRelative;
        }
        move.left.next=move.right;
        move.right.next=null;
        manipulation(root.left);
    }
}
