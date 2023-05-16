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
    //recursive sol.
    // public ListNode swapPairs(ListNode head) {
    //     if(head==null||head.next==null) return head;
    //     ListNode t=head.next;
    //     head.next=swapPairs(head.next.next);
    //     t.next=head;
    //     return t;
    // }
    
    public ListNode swapPairs(ListNode head) {
        ListNode t=new ListNode(-1);
        t.next=head;
        ListNode prev=t;
        while(head!=null && head.next!=null){
            ListNode next=head.next;
            head.next=next.next;//attaching 3rd no, to 1st next
            next.next=head;//attaching 2nd number's next to 1st
            prev.next=next;//prev.next is now the 2nd no.(new head)
            prev=head;//pre for next pair is 1st no. (ie.e head)
            head=head.next;//head will now be 3rd no. i.e head.next
        }
        return t.next;
    }
}