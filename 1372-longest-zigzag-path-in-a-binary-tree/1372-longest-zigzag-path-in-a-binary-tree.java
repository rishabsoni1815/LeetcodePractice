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
    public int longestZigZag(TreeNode root) {
        return help(root)[2];
    }
    int [] help(TreeNode root){
        if(root==null) return new int[]{-1,-1,-1};
        int l[]=help(root.left);
        int r[]=help(root.right);
        int res=Math.max(Math.max(l[1],r[0])+1,Math.max(l[2],r[2]));
        return new int[]{l[1]+1,r[0]+1,res};
    }
}