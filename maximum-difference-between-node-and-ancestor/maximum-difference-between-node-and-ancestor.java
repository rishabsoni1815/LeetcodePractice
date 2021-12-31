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
    int max=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return max;
    }
    public void dfs(TreeNode root) {
        if(root==null) return;
        help(root.left,root);
        help(root.right,root);
        dfs(root.left);
        dfs(root.right);
    }
    void help(TreeNode cur,TreeNode par){
        if(cur==null) return;
        max=Math.max(max,Math.abs(cur.val-par.val));
        help(cur.left,par);
        help(cur.right,par);
    }
}