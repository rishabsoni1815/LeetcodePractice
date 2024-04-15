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
    int help(TreeNode root,int s){
        //as if we wanted to calculate from leaves back to root then we needed current level at each node so calculated from root on the go and passed s in the recurssion only
        if(root==null) return 0;
        int cursum=s*10+root.val;
        if(root.left==null&&root.right==null) return cursum;
        return help(root.left,cursum)+help(root.right,cursum);
    }
}