import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] a) {
        int n = a.length;
        // 1. TreeSet to store pairs ordered by sum (and then index)
        TreeSet<Node> set = new TreeSet<>((x, y) -> 
            (x.nextSum != y.nextSum) ? Long.compare(x.nextSum, y.nextSum) : Integer.compare(x.idx, y.idx)
        );

        Node head = new Node(a[0], 0);
        Node prev = head;
        int badPairs = 0; // TRACKER for unsorted pairs
        
        // 2. Build List, Set, and Initial Bad Count
        for (int i = 0; i < n - 1; i++) {
            Node nextNode = new Node(a[i + 1], i + 1);
            prev.next = nextNode;
            nextNode.prev = prev;
            
            // Check if this specific pair is "bad" (unsorted)
            if (prev.val > nextNode.val) badPairs++;

            // Calculate sum and add to set
            prev.nextSum = prev.val + nextNode.val;
            set.add(prev);
            
            prev = nextNode;
        }

        int cnt = 0;
        Node dummy = new Node(-1, -1);
        dummy.next = head;
        head.prev = dummy;

        // 3. Loop until badPairs is 0 (Array is non-decreasing)
        while (badPairs > 0) {
            Node cur = set.first(); // O(1) retrieval
            
            // Logic to update pointers, set, AND badPairs count
            badPairs = updateListSetAndCount(cur, set, dummy, badPairs);
            cnt++;
        }
        return cnt;
    }

    int updateListSetAndCount(Node cur, TreeSet<Node> set, Node dummy, int badPairs) {
        Node left = cur.prev;
        Node right = cur.next;
        Node farRight = right.next;

        // --- A. Remove Old Bad Counts ---
        // 1. Check Left -> Cur
        if (left != dummy && left.val > cur.val) badPairs--;
        // 2. Check Cur -> Right (The pair being merged)
        if (cur.val > right.val) badPairs--;
        // 3. Check Right -> FarRight
        if (farRight != null && right.val > farRight.val) badPairs--;

        // --- B. Remove Nodes from Set ---
        set.remove(cur); 
        if (right.next != null) set.remove(right);
        if (left != dummy) set.remove(left);

        // --- C. Merge Logic (Cur merged into Right) ---
        right.val = cur.val + right.val; // Sum value
        
        // Pointer updates
        right.prev = left;
        left.next = right;

        // --- D. Update Sums and Set ---
        if (right.next != null) {
            right.nextSum = right.val + right.next.val;
            set.add(right);
        }
        if (left != dummy) {
            left.nextSum = left.val + right.val;
            set.add(left);
        }
        
        // --- E. Add New Bad Counts ---
        // 1. Check Left -> Right (New connection)
        if (left != dummy && left.val > right.val) badPairs++;
        // 2. Check Right -> FarRight (Right has new value)
        if (farRight != null && right.val > farRight.val) badPairs++;

        // Cleanup
        cur.next = null;
        cur.prev = null;

        return badPairs;
    }

    class Node {
        Node prev;
        Node next;
        long nextSum;
        long val;
        int idx;
        Node(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}