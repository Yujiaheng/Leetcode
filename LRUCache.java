import java.util.HashMap;

/**
 * Created by JiahengYu on 18/06/15.
 */
public class LRUCache {
    class Node{
        int key;
        int value;
        Node next=null;
        Node previous=null;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    HashMap<Integer,Node> map=new HashMap<Integer, Node>();
    int capacity=0;
    Node dummyHead=new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
    Node tail=new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
    public LRUCache(int capacity) {
        this.capacity=capacity;
        tail.previous=dummyHead;
        dummyHead.next=tail;
    }

    public int get(int key) {
        if (!map.keySet().contains(key))
            return -1;
        else {
            //put put it to the head of chain
            return map.get(key).value;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            MoveToHead(node);
        }else if (map.size()<capacity){
            Node newNode=new Node(key,value);
            MoveToHead(newNode);
            map.put(key,newNode);
        }else {
            Node newNode=new Node(key,value);
            MoveToHead(newNode);
            map.put(key,newNode);
            int endIndex=removeEnd();
            map.remove(endIndex);
        }
    }

    private int removeEnd(){
        Node entry=tail.previous;
        tail.previous.previous.next=tail;
        tail.previous=entry.previous;
        entry.previous=null;
        entry.next=null;
        return entry.key;
    }

    private void MoveToHead(Node node){
        if (node.next!=null&&node.previous!=null){
            node.previous.next=node.next;
            node.next.previous=node.previous;
        }
        node.previous=dummyHead;
        node.next=dummyHead.next;
        dummyHead.next.previous=node;
        dummyHead.next=node;
    }

    public static void main(String args[]){
        LRUCache cache=new LRUCache(2);
        cache.set(2,1);
        cache.set(2,2);
        cache.get(2);
        cache.set(1,1);
        cache.set(4,1);
        cache.get(2);
    }
}
