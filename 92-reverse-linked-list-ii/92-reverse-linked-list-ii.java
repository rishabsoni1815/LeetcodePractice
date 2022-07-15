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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return head;
        ListNode d=new ListNode(0);
        d.next=head;
        ListNode t2=d,t=head;//t2-> last element of first list (left non reversed part), t is starting node of part which we have to reverse and theis node next will be the head of (right non reversed list)
        int i=1;
        while(i<m){
            t2=t;
            t=t.next;
            i++;
        }
        ListNode temp=t,prev=null;//prev will be new head of list, t will be start of right non reversed part
        i=n-m;
        while(i-->=0){//reversing the list
            ListNode g=temp.next;
            temp.next=prev;
            prev=temp;
            temp=g;
        }
        t.next=temp;//connecting reverse part to right non reversed
        t2.next=prev;//connecting left non reversed part's last to reversed part first
        return d.next;
    }
}