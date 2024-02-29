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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int c=0,prev=-1;
        while(q.size()!=0){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode cur=q.poll();
                if(c%2==0){
                    if(cur.val%2==0 || (prev!=-1 && cur.val<=prev)) return false;
                }
                else{
                    if(cur.val%2!=0 || (prev!=-1 && cur.val>=prev)) return false;
                }
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
                prev=cur.val;
            }
            prev=-1;
            c++;
        }
        return true;
    }
}