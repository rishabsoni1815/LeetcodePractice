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
    public TreeNode removeLeafNodes(TreeNode root, int t) {
        if(root==null) return null;
        TreeNode left=removeLeafNodes(root.left,t);
        TreeNode right=removeLeafNodes(root.right,t);
        if(left==null){
            root.left=null;
        }
        if(right==null){
            root.right=null;
        }
        if(root.val==t){
            if(left==null && right==null) return null;
        }
       return root;
    }
}