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
    
    // if parent pointers are given or quries are given of LCA of 2 nodes - https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
    
    
    // if find lca of many nodes then -> https://www.youtube.com/watch?v=F8iSNXblKSU
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //works when it is guarantee that p and q will exist in the tree.
        
        //else  -> https://www.youtube.com/watch?v=T6Jr-Q6bvSU
        if(root==null) return null;
        if(root==p||root==q){
            return root;
        }
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        if(l!=null&&r!=null)
               return root;
        if(l!=null) return l;
        if(r!=null) return r;
        return null;
    }
}