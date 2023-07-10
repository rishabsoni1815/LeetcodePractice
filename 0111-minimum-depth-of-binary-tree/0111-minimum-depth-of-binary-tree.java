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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode>q=new LinkedList<>();
        int l=0;
        q.add(root);
        while(q.size()>0){
            l++;
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode u=q.poll();
                if(u.left!=null) q.add(u.left);
                if(u.right!=null) q.add(u.right);
                if(u.left==null && u.right==null) return l;
            }
        }
        return l;
    }
}