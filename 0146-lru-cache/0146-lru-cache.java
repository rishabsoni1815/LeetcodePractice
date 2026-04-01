class LRUCache {
    Node head = new Node(0, 0, 0), tail = new Node(0, 0, 0);
    Map<Integer, Node> map = new HashMap();
    int capacity;

    //head's next will have most recently used
    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);//now node is most recently used so it will go next to head
            if (isExpired(node)) {
                remove(node);
                return -1;
            }
            remove(node);
            insert(node);//inseting next to head
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {//remove existin intead of updating just v, re insert new k,v
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);//removing least recently used element i.e prev to tail
        }
        insert(new Node(key, value, Long.MAX_VALUE));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node t) {
        map.put(t.key, t);
        t.next = head.next;
        t.prev = head;
        head.next = t;
        t.next.prev = t;
    }

    private boolean isExpired(Node node) {
        return node.expiryTime != Long.MAX_VALUE
                && System.currentTimeMillis() > node.expiryTime;
    }

    public void put(int key, int value, long ttlMillis) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        long expiryTime = (ttlMillis == Long.MAX_VALUE)
                ? Long.MAX_VALUE
                : System.currentTimeMillis() + ttlMillis;
        insert(new Node(key, value, expiryTime));
    }

    class Node {

        Node prev, next;

        int key;
        int value;

        long expiryTime;

        Node(int k, int v, long exp) {

            key = k;
            value = v;
            expiryTime = exp;
        }
    }
}