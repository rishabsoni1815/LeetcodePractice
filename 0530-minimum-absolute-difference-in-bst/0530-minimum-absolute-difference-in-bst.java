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
    int diff,prev;
    public int getMinimumDifference(TreeNode root) {
        diff=Integer.MAX_VALUE;
        prev=-1;
        help(root);
        return diff;
    }
    void help(TreeNode root){
        if(root==null) return;
        if(root.left!=null) help(root.left);
        if(prev!=-1) diff=Math.min(diff,Math.abs(prev-root.val));
        prev=root.val;
        if(root.right!=null) help(root.right);
    }
}