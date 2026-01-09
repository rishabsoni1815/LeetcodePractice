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
  int deepest; TreeNode lca;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        deepest = 0;
        lca = null;
        setLCA(root,0);
        return lca;
    }
    
    private int setLCA(TreeNode node, int depth){
        deepest = Math.max(deepest, depth);
        if(node==null) return depth;
        int left = setLCA(node.left, depth+1);
        int right = setLCA(node.right, depth+1);
        if(left==deepest && right==deepest) lca = node;
        return Math.max(left, right);
    }
}