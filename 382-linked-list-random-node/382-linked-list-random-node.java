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


//  ArrayList<Integer> ans = new ArrayList<>();
//     Random rand = new Random();
//     public Solution(ListNode head) {
//         ans = new ArrayList<>();
//          rand = new Random();
//         while (head != null) {
//             ans.add(head.val);
//             head = head.next;
//         }
//     }
    
//     public int getRandom() {
//         int pick = rand.nextInt(ans.size());
//         return ans.get(pick);
//     }
    
    
    
//O(1) space sol - https://youtu.be/Lsquc54IciI?t=588

ListNode h;
Random rand = new Random();

 public Solution(ListNode head) {
        h=head;
    }
    
    public int getRandom() {
        rand = new Random();
        int n=0,res=0;
        ListNode t=h;
        while(t!=null){
            n++;
            if(rand.nextInt(n)==0){
                res=t.val;
            }
            t=t.next;
        }
        return res;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */