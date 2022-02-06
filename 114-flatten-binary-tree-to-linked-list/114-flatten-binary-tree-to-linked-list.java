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


/*

// TC - O(N) 
// SC - O(1) 
go to rightmost of root's left and connect its right to root's right and connect root's right to root's left -> see tuf video
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
		while (cur != null)
		{
			if(cur.left != null)
			{
				TreeNode pre = cur.left;
				while(pre.right != null)
				{
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
    }
}


*/
class Solution {
  
    public TreeNode flatten(TreeNode root) {
        flattenUtil(root);
        return root;
    }
    
    public TreeNode flattenUtil(TreeNode root) {
        if (root == null)
            return null;
        if(root.left==null && root.right==null) return root;

        TreeNode ltail=flattenUtil(root.left);
        TreeNode rtail=flattenUtil(root.right);

        if(ltail!=null && rtail!=null){
            ltail.right=root.right;
            root.right=root.left;
            root.left=null;
        }else if(ltail!=null){
            root.right=root.left;
            root.left=null;
            return ltail;
        }
        return rtail;
    }
}