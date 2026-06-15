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
    //for odd doesn't work removes 1 element ahead 
    // public ListNode deleteMiddle(ListNode head) {
    //   if(head==null) return null;
    //     ListNode dhead=head;
    //     ListNode s=head,f=head;
    //     while(f.next!=null&&f.next.next!=null){
    //         s=s.next;
    //         f=f.next.next;
    //     }
    //     s.next=s.next.next;
    //     return dhead;
    // }
    
    
    //for odd doesn't work removes 1 element ahead so added dummy and started from dhead so we remove one lement before
     public ListNode deleteMiddle(ListNode head) {
      if(head==null) return null;
        ListNode dhead=new ListNode(-1);
         dhead.next=head;
        ListNode s=dhead,f=dhead;
        while(f.next!=null&&f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        s.next=s.next.next;
        return dhead.next;
    }
}