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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int r=0;
        ListNode ans=new ListNode(-1);
        ListNode y=ans;
        while(l1!=null&&l2!=null){
           
            ans.next=new ListNode((l1.val+l2.val+r)%10);
             r=(l1.val+l2.val+r)/10;
            ans=ans.next;
            l1=l1.next;l2=l2.next;
        }
  
        while(l1!=null){
            ans.next=new ListNode((l1.val+r)%10);
            r=(l1.val+r)/10;
            ans=ans.next;
             l1=l1.next;
           // l2=l2.next;
        }
       
         while(l2!=null){    
            ans.next=new ListNode((l2.val+r)%10);
             r=(l2.val+r)/10;
            ans=ans.next;
             // l1=l1.next;
             l2=l2.next;
        }
        if(r!=0){
            ans.next=new ListNode(r);
        }
        return y.next;
    }
}