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
        int c=1;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        c=1;
        ListNode dhead=new ListNode(-1);
        dhead.next=head;
        ListNode prev=dhead;
        while(head!=null){
            if(c==left) {
                ListNode cur=rev(head,right);
                head=prev.next;
                prev.next=cur;
            }
            prev=head;
            head=head.next;
            c++;
        }
        return dhead.next;
    }
    ListNode rev(ListNode head,int right){
            ListNode prev=null,start=head;
            while(head!=null){
                ListNode next=head.next;
                head.next=prev;
                prev=head;
                head=next;
                if(right==c) break;
                c++;
            }
            start.next=head;
            return prev;
    }
}