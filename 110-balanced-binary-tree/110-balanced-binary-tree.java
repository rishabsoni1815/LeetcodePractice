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
    	boolean ans;
    boolean isBalanced(TreeNode root) {
        ans=true;
    	height(root);
    	return ans;
    }

int height(TreeNode root) {
	if(root==null||ans==false) return 0;
	int l=0,r=0;
	if(root.left!=null) {
		l=height(root.left);
	}
	if(root.right!=null) {
		r=height(root.right);
	}
	if(Math.abs(l-r)>1) {
		ans=false;
	}
	return (1+Math.max(l, r));
}
}