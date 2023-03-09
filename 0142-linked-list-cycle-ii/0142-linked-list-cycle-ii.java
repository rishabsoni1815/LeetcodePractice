/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
         if from start to start of loop dis is L1
         and from start of loop to intersection of slow and fast is distance L2
         the slow has moved till now = L1+L2
         and fast has moved till now = L1+L2+nC ( C is length of loop )
         and we know fast = 2*slow dis
         hence 
         2(L1+L2)=L1+L2+nC
         => L1=(nC-L2), hence L1=(nC-L2)
         hence we move start L1 and fast (nC-L2) ( by moving 1 step only )the it reaches start of loop
        */
                ListNode slow = head;
                ListNode fast = head;
                while (fast!=null && fast.next!=null){
                    fast = fast.next.next;
                    slow = slow.next;
                    
                    if (fast == slow){
                        fast=head;
                        while (fast != slow){
                            slow = slow.next;
                            fast = fast.next;
                        }
                        return slow;
                    }
                }
                return null;
            }
}