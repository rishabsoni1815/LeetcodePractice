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
    public List<TreeNode> delNodes(TreeNode root, int[] d) {
        HashSet<Integer>s=new HashSet<>();
        for(int x:d) s.add(x);
        List<TreeNode>ans=new ArrayList<>();
        root=help(root,ans,s);
        if(root!=null) ans.add(root);
        return ans;
    }
    TreeNode help(TreeNode root,List<TreeNode>ans,HashSet<Integer>h){
        if(root==null) return null;
        TreeNode left=help(root.left,ans,h);
        TreeNode right=help(root.right,ans,h);
        if(h.contains(root.val)){
            if(left!=null) ans.add(left);
            if(right!=null) ans.add(right);
            return null;
        }
        root.left=left;
        root.right=right;
        return root;
    }
}