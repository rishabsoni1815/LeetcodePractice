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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //works when it is guarantee that p and q will exist in the tree.
        
        //else  -> https://www.youtube.com/watch?v=T6Jr-Q6bvSU
        if(root==null) return null;
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        if(root==p||root==q){
            return root;
        }
        if(l!=null&&r!=null)
               return root;
        if(l!=null) return l;
        if(r!=null) return r;
        return null;
    }
}