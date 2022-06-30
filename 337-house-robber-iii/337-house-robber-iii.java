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
class Pair{
    int inc;
    int ninc;
    Pair(int inc,int ninc){
        this.inc=inc;
        this.ninc=ninc;
    }
}
class Solution {
    
    public int rob(TreeNode root) {
        Pair ans=help(root);
        return Math.max(ans.inc,ans.ninc);
    }
    Pair help(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        if(root.left==null && root.right==null){
            return new Pair(root.val,0);
        }
        Pair l=help(root.left);
        Pair r=help(root.right);
        Pair ans=new Pair(0,0);
        ans.inc=root.val+((l.ninc+r.ninc));
        ans.ninc=(Math.max(l.inc,l.ninc)+Math.max(r.inc,r.ninc));
        // System.out.println(root.val+" "+ans.inc+" "+ans.ninc);
        return ans;
    }
}