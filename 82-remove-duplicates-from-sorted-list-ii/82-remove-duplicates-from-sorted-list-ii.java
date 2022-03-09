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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode d=new ListNode(0);
        d.next=head;
        ListNode c=head,prev=d;
        
        while(c!=null){
           if(c.next!=null&&c.next.val==c.val){
               while(c.next!=null&&c.next.val==c.val){
                    c=c.next;
                }
                prev.next=c.next;
           }else{
               prev=c;
           }
                c=c.next;
        }
        return d.next;
    }
}