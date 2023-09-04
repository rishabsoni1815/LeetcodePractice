/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }    https://www.youtube.com/watch?v=8NBkGnY5iJ8&list=PLBTCXiV4KOCRFRn0ZIoaNPX8TYHgbAVPZ&index=4&t=0s
 * }
 */
public class Solution {
    /*
     let say when slow entern the cycle the distance between s and f is k after this f is +2 ans s is +1 so resultant dis b/w them is k+1 then k+2 ...k+x and one time k+x will be n where n is length of loop so they will meet as k is increasing by 1 always not by 2 or 3 so bount to become n (for some x k+x=n ) 
    
    */
    public boolean hasCycle(ListNode head) {
        ListNode t1=head,t2=head;
        while(t1!=null&&t1.next!=null){
            // if(t1==t2) return true;//wrong for intial cond. we haave initialised t1 ans t2 both with head so same always
            t2=t2.next;
            t1=t1.next.next;
            if(t1==t2) return true;
        }
        return false;
    }
}