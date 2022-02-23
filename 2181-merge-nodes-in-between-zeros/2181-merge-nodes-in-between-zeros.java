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
    public ListNode mergeNodes(ListNode head) {
        int cur=0;
        ListNode ans=new ListNode(-1);head=head.next;
        ListNode temp=ans;
        while(head!=null){
            if(head.val==0){
                head.val=cur;
                ans.next=head;
                cur=0;
                ans=head;
            }else{
                cur+=head.val;
            }
            head=head.next;
        }
        return temp.next;
    }
}