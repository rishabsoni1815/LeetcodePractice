class LRUCache {
    Node head;
    Node tail;
    int cap=0;
    int size=0;
    HashMap<Integer,Node>h;
    public LRUCache(int c) {
        head=new Node();
        tail=new Node();
        head.key=-1;head.val=-1;
        tail.key=-1;tail.val=-1;
        head.next=tail;
        tail.prev=head;
        cap=c;
        size=0;
        h=new HashMap<>();
    }
    
    public int get(int k) {
        if(h.containsKey(k)){
            updateInFront(h.get(k));
            return h.get(k).val;
        }
        return -1;
    }
    
    public void put(int k, int v) {
        if(h.containsKey(k)){
            h.get(k).val=v;
            updateInFront(h.get(k));
        }else{
            Node n=new Node();
            n.key=k;n.val=v;
            h.put(k,n);
            updateInFront(n);
            size++;
            if(size>cap) {
                removeLast();
            }
        }
    }

    public void updateInFront(Node cur){
        removeForUpdation(cur);
        Node temp=head.next;
        head.next=cur;
        cur.prev=head;
        cur.next=temp;
        temp.prev=cur;
    }

    public void removeForUpdation(Node node){
        if(node.prev == null || node.next == null)
            return;
        Node temp=node.next;
        node.prev.next=temp;
        temp.prev=node.prev;
        node=null;
    }

    public void removeLast(){
        if(size==0) return;
        size--;
        Node temp=tail.prev;
        temp.prev.next=tail;
        tail.prev=temp.prev;
        h.remove(temp.key);
        temp=null;
    }
}

class Node{
    Node prev;
    Node next;
    int key;
    int val;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */