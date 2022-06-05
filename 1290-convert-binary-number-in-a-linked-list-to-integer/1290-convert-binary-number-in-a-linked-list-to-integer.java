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
    public int getDecimalValue(ListNode head) {
        //1101 -> 1*8 + 1*4 +0*2 +1*1 or 1*(1) +(1)*2+1 {11} +((1)*2+1)*2+0 {110} + (((1)*2+1)*2+0)*2+1 {1101}
        int ans=head.val;
        while(head.next!= null){
            ans=(ans*2)+head.next.val;
            head=head.next;
        }
        return ans;
    }
}