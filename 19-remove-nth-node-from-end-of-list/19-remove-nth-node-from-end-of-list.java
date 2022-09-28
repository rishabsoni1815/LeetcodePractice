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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dhead=new ListNode(-1);
        dhead.next=head;
        
        ListNode t=head;
        int nn=n;
        while(n-->0){
            t=t.next;
        }
        if(t==null) return dhead.next.next;
        while(t!=null && t.next!=null){
            head=head.next;
            t=t.next;
        }
        if(head.next!=null) head.next=head.next.next;
        return dhead.next;
    }
}