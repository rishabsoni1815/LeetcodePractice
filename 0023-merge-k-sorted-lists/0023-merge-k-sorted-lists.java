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
    public ListNode mergeKLists(ListNode[] lists) { 
        // Comparator<ListNode> cmp;
        // cmp = new Comparator<ListNode>() {  
        // @Override
        // public int compare(ListNode o1, ListNode o2) {
        //     // TODO Auto-generated method stub
        //     return o1.val-o2.val;
        // }
        // };
 
        Queue<ListNode> q = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }        
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){ 
            point.next = q.poll();
            point = point.next; 
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }
}