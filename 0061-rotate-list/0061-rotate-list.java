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
    public ListNode rotateRight(ListNode head, int k) {
        int size=0;
        ListNode t=head,t1=null;
        
        while(t!=null){
            size++;
            t1=t;
            t=t.next;
        }
        if(size==0) return null;
        t1.next=head;//making the list circular
        k=k%size;// as if k=3*n + 5 then only 5 is valuable
        t=head;
        for(int i=1;i<(size-k);i++){
            t=t.next;
        }
        head=t.next;//new head
        t.next=null;
        return head;
    }
}