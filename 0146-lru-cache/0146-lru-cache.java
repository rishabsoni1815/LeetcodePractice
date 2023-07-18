class LRUCache {  
  Node head = new Node(0, 0), tail = new Node(0, 0);
  Map<Integer, Node> map = new HashMap();
  int capacity;
  //head's back will have most recently used
  public LRUCache(int _capacity) {
    capacity = _capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if(map.containsKey(key)) {
      Node node = map.get(key);//now node is most recently used so it will go next to head
      remove(node);
      insert(node);//inseting next to head
      return node.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if(map.containsKey(key)) {
      remove(map.get(key));
    }
    if(map.size() == capacity) {
      remove(tail.prev);//removing least recently used element i.e prev to tail
    }
    insert(new Node(key, value));
  }
  
  private void remove(Node node) {
    map.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
  
  private void insert(Node t){
      map.put(t.key,t);
      t.next=head.next;
      t.prev=head;
      head.next=t;
      t.next.prev=t;
  }
  
  class Node{
    Node prev, next;
    int key, value;
    Node(int _key, int _value) {
      key = _key;
      value = _value;
    }
  }
}
