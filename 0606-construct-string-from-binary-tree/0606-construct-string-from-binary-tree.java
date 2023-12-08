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
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        if(root.left==null&&root.right==null) return root.val+"";
        String ans=""+root.val;
        ans+=("("+tree2str(root.left)+")");
        String r=tree2str(root.right);
        if(r.length()!=0) ans+=("("+r+")");
        return ans;
    }
}