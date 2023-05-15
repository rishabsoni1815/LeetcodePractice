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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        ListNode temp1=head;
        int i=1;
        while(i<k){
            temp=temp.next;
            i++;
        }
        ListNode first=temp;
        while(temp.next!=null){
            temp1=temp1.next;
            temp=temp.next;
        }
        
        int x=temp1.val;
        temp1.val=first.val;
        first.val=x;
        return head;
    }
}