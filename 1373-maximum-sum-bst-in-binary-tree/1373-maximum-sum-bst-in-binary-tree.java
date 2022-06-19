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
class bs{
    boolean isbst;
    int min;
    int max;
    int ans;
    bs(boolean isbst,int max,int min,int ans){
        this.isbst=isbst;
        this.min=min;
        this.max=max;
        this.ans=ans;
    }
}
class Solution {//like largest size bst
    int o=0;//important
    public int maxSumBST(TreeNode root) {
        o=0;
        bs b=help(root);
        return o;
    }
      bs help(TreeNode root){
        if(root==null){
           return new bs(true,Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        }
        bs l=help(root.left);
        bs r=help(root.right);
        if(l.isbst&&r.isbst&&l.max<root.val&&r.min>root.val){
            bs t=new bs(true,Math.max(root.val,r.max),Math.min(root.val,l.min),l.ans+r.ans+root.val);
            o=Math.max(o,t.ans);//have to do this as -ve values are also there, so a bigger size bst can have less sum
            return t;
        }
        bs t=new bs(false,-1,-2,Math.max(l.ans,r.ans));
        return t;
    }
}