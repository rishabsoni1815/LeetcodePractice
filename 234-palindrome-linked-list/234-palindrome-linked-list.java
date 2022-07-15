/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution { 
    
    //recursive----->
        
    // ListNode left;
    // public boolean isPalindrome(ListNode head) 
    // {
    //     left=head;
    //    return p(head);
    // }
    // public boolean p(ListNode node) {
    //   if(node==null) return true;
    //     boolean h=p(node.next); 
    //     if(h==false) return false;
    //     if(node.val!=left.val) return false;
    //     left=left.next;
    //     return true;
    // }
    
    
    //find center reverse next half the compare
    
public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    ListNode h2 = reverse(slow);
    ListNode h1 = head;
    
    while (h2 != null && h1!=null) {
        if (h2.val != h1.val) {
            return false;
        }
        h2 = h2.next;
        h1 = h1.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
    
}