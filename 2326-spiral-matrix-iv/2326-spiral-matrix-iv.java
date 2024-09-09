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
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int dr=0;//0->right,1->down,2->left,3->up
        int ans[][]=new int[n][m];
        int l=0,r=m-1,u=0,d=n-1,i=0,j=0;
        while(l<=r && u<=d){
            if(dr==0){
                for(int k=l;k<=r;k++){
                    if(head!=null){
                        ans[u][k]=head.val;
                        head=head.next;   
                    }else{
                        ans[u][k]=-1;
                    }
                }
                u++;
            }else if(dr==1){
                for(int k=u;k<=d;k++){
                    if(head!=null){
                        ans[k][r]=head.val;
                        head=head.next;   
                    }else{
                        ans[k][r]=-1;
                    }
                }
                r--;
            }else if(dr==2){
                for(int k=r;k>=l;k--){
                    if(head!=null){
                        ans[d][k]=head.val;
                        head=head.next;   
                    }else{
                        ans[d][k]=-1;
                    }
                }
                d--;
            }else if(dr==3){
                for(int k=d;k>=u;k--){
                    if(head!=null){
                        ans[k][l]=head.val;
                        head=head.next;   
                    }else{
                        ans[k][l]=-1;
                    }
                }
                l++;
            }
            dr=(dr+1)%4;
        }
        return ans;
    }
}