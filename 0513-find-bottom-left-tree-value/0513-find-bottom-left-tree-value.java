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
    int left=-1;
    int maxLevel=-1;
    public int findBottomLeftValue(TreeNode root) {
        //means the first element which comes in preorder at last level
        left=-1;maxLevel=-1;
        help(root,0);
        return left;
    }
    void help(TreeNode root,int cur){
        if(root==null) return;
        if(cur>maxLevel){
            maxLevel=cur;
            left=root.val;
        }
        help(root.left,cur+1);
        help(root.right,cur+1);
    }   
}