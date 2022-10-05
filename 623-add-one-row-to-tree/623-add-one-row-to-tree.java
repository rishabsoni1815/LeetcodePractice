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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root==null) return root;
        if(d==1){
            TreeNode t=new TreeNode(v);
            t.left=root;
            return t;
        }
        else if(d==2){
            TreeNode l=root.left;
            TreeNode r=root.right;
            root.left=new TreeNode(v);
            root.right=new TreeNode(v);
            root.left.left=l;
            root.right.right=r;
        }else{
            root.left=addOneRow(root.left,v,d-1);
            root.right=addOneRow(root.right,v,d-1);
        }
        return root;
    }
}