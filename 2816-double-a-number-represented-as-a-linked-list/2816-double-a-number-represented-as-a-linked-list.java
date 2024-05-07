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

/*
//recursive
class Solution {
    public ListNode doubleIt(ListNode head) {
        int x=help(head);
        if(x!=0) {
            ListNode dhead=new ListNode(x);
            dhead.next=head;
            return dhead;
        }
        return head;
    }
    int help(ListNode head){
        if(head==null) return 0;
        int x=help(head.next);
        int y=(head.val*2+x);
        head.val=y%10;
        return y/10;
    }
}
*/

class Solution {
    //as 2*4 is signle digit after that becomes 2 digit and always 1 is carried to next number during multiplication for numbers >=4 (as 2*9 is also 18 so 1 will be carried forward)
    public ListNode doubleIt(ListNode head) {
        ListNode dhead=new ListNode(0);
        ListNode thead=dhead;
        dhead.next=head;
        while(dhead!=null){
            if(dhead.next!=null){
                if(dhead.next.val>4){
                    dhead.val=(dhead.val*2 + 1)%10;
                }else{
                    dhead.val=(dhead.val*2)%10;
                }   
            }else{
                dhead.val=(dhead.val*2)%10;
            }
            dhead=dhead.next;
        }
        if(thead.val==0) return thead.next;
        return thead;
    }
}