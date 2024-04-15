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
    public int sumNumbers(TreeNode root) {
        return help(root,0);
    }
    int help(TreeNode root,int x){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return x*10+root.val;
        return help(root.left,x*10+root.val)+help(root.right,x*10+root.val);
    }
}
