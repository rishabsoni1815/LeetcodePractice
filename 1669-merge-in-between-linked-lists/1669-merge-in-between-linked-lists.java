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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head=list1;
        int x=1;
        while(list1!=null && x++!=a){
            list1=list1.next;
        }
        ListNode temp=list1.next;
        list1.next=list2;
        x=b-a+1;
        while(temp!=null && x--!=0){
            temp=temp.next;
        }
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=temp;
        return head;
    }
}