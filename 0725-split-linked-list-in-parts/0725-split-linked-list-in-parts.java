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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size=0;
        ListNode thead=head;
        while(thead!=null){
            thead=thead.next;
            size++;
        }
        ListNode []ans=new ListNode[k];
        int s=size/k;
        int r=size%k;
        thead=head;
        int i=0;
        while(thead!=null){
            int cs=1;
            if(r>0) cs--;
            ListNode temp=thead,prev=null;
            while(cs<=s){
                prev=thead;
                thead=thead.next;
                cs++;
            }
            prev.next=null;
            ans[i]=temp;
            i++;
            r--;
        }
        return ans;
    }
}