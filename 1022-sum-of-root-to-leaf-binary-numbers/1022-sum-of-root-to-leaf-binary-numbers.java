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
    public int sumRootToLeaf(TreeNode root) {
        return help(root,0);
    }
    int help(TreeNode root,int x){
        if(root==null) return 0;
        int nx=x<<1;
        if(root.val==1){
            nx|=1;
        }
        if(root.left==null && root.right==null) {
            return nx;
        }
        return help(root.left,nx)+help(root.right,nx);
    }
}