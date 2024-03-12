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
    public ListNode removeZeroSumSublists(ListNode head) {
        //like we do in subraay with sum 0 check in hashmap if we have sum then it means btw these 2 sums there is subarray with sum 0 imp is to remove the linkesdelist entries in hashmap to avoid wrong duplicate values
        HashMap<Integer,ListNode>h=new HashMap<>();
        ListNode dhead=new ListNode(-1);
        dhead.next=head;
        h.put(0,dhead);
        int sum=0;
        while(head!=null){
            sum+=head.val;
            if(h.containsKey(sum)){
                ListNode prev=h.get(sum);
                head=prev.next;
                int p=sum+head.val;
                while(p!=sum){
                    h.remove(p);
                    head=head.next;
                    p+=head.val;
                }
                prev.next=head.next;
            }else{
                h.put(sum,head);
            }
            head=head.next;
        }
        return dhead.next;
    }
}