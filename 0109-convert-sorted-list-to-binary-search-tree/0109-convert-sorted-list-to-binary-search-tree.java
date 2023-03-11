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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode c=getMid(head);
        if(c==head && c.next==null) return new TreeNode(c.val);
        TreeNode cur=new TreeNode();
        if(c.next!=null){
            cur.val=c.next.val;
        }
        // System.out.println(head.val+" "+c.val);
        if(c.next!=null) cur.right=sortedListToBST(c.next.next);
        c.next=null;
        cur.left=sortedListToBST(head);
        return cur;
    }
    ListNode getMid(ListNode head){
        ListNode slow=head,fast=head,prev=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        return prev;
    }
}