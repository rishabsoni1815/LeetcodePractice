/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode t) {
        if(original==null) return null;
        if(original==t) return cloned;
        TreeNode l=getTargetCopy(original.left,cloned.left,t);
        if(l!=null) return l;
        TreeNode r=getTargetCopy(original.right,cloned.right,t);
        return r;
    }
}