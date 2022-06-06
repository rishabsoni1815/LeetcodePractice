/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// o(n) space (map) sol.
// public class Solution {
//     public Node copyRandomList(Node head) {
//         if (head == null) {
//             return null;
//         }
        
//        Map<Node, Node> map = new HashMap<>();

//         Node cur = head;
//         while(cur != null) {
//             map.put(cur, new Node(cur.val));
//             cur = cur.next;
//         }
        
//         for (Map.Entry<Node, Node> entry : map.entrySet()) {
//             Node newNode = entry.getValue();
//             newNode.next = map.get(entry.getKey().next);
//             newNode.random = map.get(entry.getKey().random);
//         }
        
//         return map.get(head);
//     }
// }


///O(1)space 
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        // First round: make copy of each node,
          // and link them together side-by-side in a single list.
        Node temp=head;
        while(temp!=null){
            Node n=temp.next;
            Node copy=new Node(temp.val);
            copy.next=temp.next;
            temp.next=copy;
            temp=n;
        }
        
          // Second round: assign random pointers for the copy nodes.
        temp=head;
        while(temp!=null){
            Node copy=temp.next;
           if(temp.random!=null) copy.random=temp.random.next;
            temp=copy.next;
        }
        
        
          // Third round: restore the original list, and extract the copy list.
        Node nhead=head.next;
        temp=head;
        while(temp!=null){
            Node copy=temp.next;
            Node n=copy.next;
            temp.next=n;
           if(n!=null) copy.next=n.next;
            temp=n;
        }
        return nhead;
    }
}