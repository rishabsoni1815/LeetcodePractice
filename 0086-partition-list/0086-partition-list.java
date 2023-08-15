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
    public ListNode partition(ListNode head, int x) {
        ListNode dhead=new ListNode(-1);
        ListNode head1=new ListNode(-1);
        ListNode temp=dhead;
        ListNode temp1=head1;
        while(head!=null){
            if(head.val<x){
                dhead.next=head;
                dhead=dhead.next;
            }else{
                head1.next=head;
                head1=head1.next;
            }
            head=head.next;
        }
        head1.next=null;
        dhead.next=temp1.next;
        return temp.next;
    }
}