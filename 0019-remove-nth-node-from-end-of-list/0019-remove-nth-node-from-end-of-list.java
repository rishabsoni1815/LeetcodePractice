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
        ListNode thead=new ListNode(-1);
        thead.next=head;
        ListNode first=head;
        ListNode last=head;
        while(n-->1){
            last=last.next;
        }
        ListNode prev=thead;//coz if the first element is the one which is to be removed then removal becomes easy as prev can then be assigned to thead
        while(last.next!=null){
            prev=first;
            last=last.next;
            first=first.next;
        }
        prev.next=prev.next.next;
        return thead.next;
    }
}