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
 ArrayList<Integer> ans = new ArrayList<>();
    Random rand = new Random();
    public Solution(ListNode head) {
        ans = new ArrayList<>();
         rand = new Random();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int pick = rand.nextInt(ans.size());
        return ans.get(pick);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */