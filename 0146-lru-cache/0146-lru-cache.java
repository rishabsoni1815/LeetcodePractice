class LRUCache {
    Node head;
    Node tail;
    int n=0;
    int cap=0;
    HashMap<Integer,Node>h;
    public LRUCache(int n) {
        this.n=n;
        cap=0;
        h=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int k) {
        if(!h.containsKey(k)) return -1;
        Node cur=h.get(k);
        int ans=cur.val;
        remove(cur);
        add(cur);
        return ans;
    }

    public void add(Node node){
        Node temp=head.next;
        head.next=node;
        node.prev=head;
        node.next=temp;
        temp.prev=node;
        h.put(node.key,node);
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        if(h.containsKey(node.key)) h.remove(node.key);
        node=null;
    }
    
    public void put(int k, int v) {
        if(h.containsKey(k)){
            Node cur=h.get(k);
            cur.val=v;
            remove(cur);
            add(cur);
        }else{
            if(cap+1>n) {
                remove(tail.prev);
                add(new Node(k,v));
            }else{
                cap++;
                add(new Node(k,v));
            }
        }
    }
}

class Node{
    Node next;
    Node prev;
    int key;
    int val;
    long sec;
    Node(int key,int val) {
        this.val=val;
        this.key=key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */