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
    long max=0;
    int mod=(int)(1e9+7);
    public int maxProduct(TreeNode root) {
        max=0;
        long sum=sum(root);
        help(root,sum);
        return (int)(max%1000000007);
    }
    long help(TreeNode root,long sum){
        if(root==null) return 0;
        long lsum=help(root.left,sum);
        long rsum=help(root.right,sum);
        long o1=(lsum * (sum-lsum));
        long o2=(rsum * (sum-rsum));
        max=Math.max(max,Math.max(o1,o2));
        return ((long)root.val+lsum+rsum);
    }
    long sum(TreeNode root){
        if(root==null) return 0;
        return (long)root.val+sum(root.left)+sum(root.right);
    }
}