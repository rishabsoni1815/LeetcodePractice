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
    int ans=0;
    public int distributeCoins(TreeNode root) {
        help(root);
        return ans;
    }
    int help(TreeNode root){//return me the required
        if(root==null) return 0;//nothing required
        int l=help(root.left);//required from left child
        int r=help(root.right);//required from right if + it require amd if - it will give to parent i.e. root(left's parent)
        
        ans+=(Math.abs(l)+Math.abs(r));//steps taken -> if -ve then also steps are needed to give to parent from left/right and if + then also steps are needed for parent to give to left/right so abs
        int x=root.val;//the number i will give to parent of root
        return x+l+r-1;
    }
}