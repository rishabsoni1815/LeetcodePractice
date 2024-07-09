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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode cur=head.next;
        if(cur.next==null) return new int[]{-1,-1};
        ListNode next=cur.next;
        int min=Integer.MAX_VALUE,max=-1,i=1,prevI=0,firstI=0;
        while(next!=null){
            // System.out.println(prev.val+" "+cur.val+" "+next.val);
            if((cur.val>prev.val && cur.val>next.val) || (cur.val<prev.val && cur.val<next.val)){
               if(prevI!=0) min=Math.min(min,i-prevI);
               if(prevI!=0) max=Math.max(max,i-firstI);
                if(prevI==0) firstI=i;
                // System.out.println(prevI+" "+i);
                prevI=i;
            }
            i++;
            next=next.next;
            cur=cur.next;
            prev=prev.next;
        }
        if(max==-1){//nothing found return -1,-1
            return new int[]{-1,-1};
        }else{
            return new int[]{min,max};
        }
    }
}