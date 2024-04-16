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
    public TreeNode addOneRow(TreeNode root, int val, int d) {
        if(d==1){
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }
        return help(root,val,d);
    }
    TreeNode help(TreeNode root, int val, int d){
        if(root==null) return null;
        if((d-1)==1){
            TreeNode tleft=root.left,tright=root.right;
            root.left=new TreeNode(val,tleft,null);
            root.right=new TreeNode(val,null,tright);
            return root;
        }
        addOneRow(root.left,val,d-1);
        addOneRow(root.right,val,d-1);
        return root;
    }
}