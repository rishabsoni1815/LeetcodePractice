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
    public ListNode doubleIt(ListNode head) {
        int x=help(head);
        if(x!=0) {
            ListNode dhead=new ListNode(x);
            dhead.next=head;
            return dhead;
        }
        return head;
    }
    int help(ListNode head){
        if(head==null) return 0;
        int x=help(head.next);
        int y=(head.val*2+x);
        head.val=y%10;
        return y/10;
    }
}