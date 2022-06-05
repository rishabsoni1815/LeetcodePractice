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
        ListNode temp=new ListNode(-1);
        ListNode dhead=temp;
        while(head!=null){
            temp.next=head;
            temp=temp.next;
            while(head!=null && head.val==temp.val){
                head=head.next;
            }
        }
        temp.next=null;
        return dhead.next;
    }
}