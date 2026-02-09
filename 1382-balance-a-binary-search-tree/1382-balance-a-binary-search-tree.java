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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode>in=new ArrayList<>();
        help(root,in);
        return balance(in,0,in.size()-1);
    }
    void help(TreeNode root,ArrayList<TreeNode> in){
        if(root==null) return;
        help(root.left,in);
        in.add(root);
        help(root.right,in);
    }
    TreeNode balance(ArrayList<TreeNode>in, int l,int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode cur=in.get(mid);
        cur.left=balance(in,l,mid-1);
        cur.right=balance(in,mid+1,r);
        return cur;
    }
}