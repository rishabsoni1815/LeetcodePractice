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
    public ListNode modifiedList(int[] a, ListNode head) {
        HashSet<Integer>h=new HashSet<>();
        for(int i=0;i<a.length;i++){
            h.add(a[i]);
        }
        ListNode thead=new ListNode(-1);
        ListNode temp=thead;
        thead.next=head;
        while(thead.next!=null){
            if(h.contains(thead.next.val)){
                thead.next=thead.next.next;
            }
            else thead=thead.next;
        }
        return temp.next;
    }
}