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
    int ans=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        help(root);
        return ans;
    }
    int [] help(TreeNode root){
        if(root==null) {
             int t[]=new int[2];
            t[0]=Integer.MAX_VALUE;
            t[1]=Integer.MIN_VALUE;
            return t;
        }
        int a[]=help(root.left);
        int b[]=help(root.right);
        int t[]=new int[2];
        t[0]=Math.min(a[0],b[0]);
        t[1]=Math.max(a[1],b[1]);
        if(t[0]!=Integer.MAX_VALUE&&t[1]!=Integer.MIN_VALUE)ans=Math.max(ans,Math.max(Math.abs(root.val-t[0]),Math.abs(root.val-t[1])));
        t[0]=Math.min(root.val,t[0]);
        t[1]=Math.max(root.val,t[1]);
        return t;
    }
}