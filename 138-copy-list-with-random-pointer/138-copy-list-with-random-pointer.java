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
          Node iter = head; 
          Node front = head;

          // First round: make copy of each node,
          // and link them together side-by-side in a single list.
          while (iter != null) {
            front = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;

            iter = front;
          }

          // Second round: assign random pointers for the copy nodes.
          iter = head;
          while (iter != null) {
            if (iter.random != null) {
              iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
          }

          // Third round: restore the original list, and extract the copy list.
          iter = head;
          Node pseudoHead = new Node(0);
          Node copy = pseudoHead;

          while (iter != null) {
            front = iter.next.next;

            // extract the copy
            copy.next = iter.next;
            copy = copy.next;

            // restore the original list
            iter.next = front;

            iter = front;
          }

          return pseudoHead.next;
    }
}