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
    int ans=0;
    public int sumNumbers(TreeNode root) {
        ans=0;
        help(root);
        return ans;
    }
    int help(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) {
            ans+=root.val;
            return 1;
        }
        else{
            int x=10*help(root.left);
            int y=10*help(root.right);
            ans+=(root.val*x);
            ans+=(root.val*y);
            return x+y;
        }
    }
}