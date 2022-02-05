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
    public boolean hasPathSum(TreeNode root, int sum) {
       return find(root,0,sum);
    }
   boolean find(TreeNode root,int csum,int sum){
       if(root==null) return false;
        boolean ans=false;
       if((csum+root.val)==sum&&root.left==null&&root.right==null){
           ans=true;
       }
       ans|=find(root.left,csum+root.val,sum)||find(root.right,csum+root.val,sum);
       return ans;
    }
}