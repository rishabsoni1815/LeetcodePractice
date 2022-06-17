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

// using long as when node value is INT_min or max gives error
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return help(root,Long.MIN_VALUE,Long.MAX_VALUE);
//     }
//     boolean help(TreeNode root,long l,long r){
//         if(root==null) return true;
//         if(root.val<=l||root.val>=r){
//        return false;
//         }
//         return help(root.left,l,root.val)&&help(root.right,root.val,r);
//     }
// }
//or use Integer class
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        
        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}