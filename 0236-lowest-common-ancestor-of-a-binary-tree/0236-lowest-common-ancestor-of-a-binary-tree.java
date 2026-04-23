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
    
    // if parent pointers are given(lca iii leetcode premium) or quries are given of LCA of 2 nodes(use parent pointer) - https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
    
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
        //works when it is guarantee that p and q will exist in the tree.
        
    /*
    
    class Result {
    TreeNode node;
    boolean foundX;
    boolean foundY;

    Result(TreeNode node, boolean foundX, boolean foundY) {
        this.node = node;
        this.foundX = foundX;
        this.foundY = foundY;
    }
}

public class RobustLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode x, TreeNode y) {
        Result res = helper(root, x, y);
        // Only return the node if both x and y were actually found in the tree
        if (res.foundX && res.foundY) {
            return res.node;
        }
        return null;
    }

    private Result helper(TreeNode root, TreeNode x, TreeNode y) {
        if (root == null) return new Result(null, false, false);

        Result left = helper(root.left, x, y);
        Result right = helper(root.right, x, y);

        boolean foundX = (root == x) || left.foundX || right.foundX;
        boolean foundY = (root == y) || left.foundY || right.foundY;

        // If the current root is x or y, or if left and right each found one
        if (root == x || root == y || (left.node != null && right.node != null)) {
            return new Result(root, foundX, foundY);
        }

        // Otherwise, return the non-null result from children
        return new Result(left.node != null ? left.node : right.node, foundX, foundY);
    }
}
     */