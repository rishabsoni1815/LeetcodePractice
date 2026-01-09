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
    int max=0;
    TreeNode ans;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ans=root;
        max=0;
        help(root,0);
        return ans;
    }
    int help(TreeNode root,int l){
        if(root==null) return l;
        int o1=help(root.left,l+1);
        int o2=help(root.right,l+1);
        if(Math.max(o1,o2)>=max){
            if(Math.max(o1,o2)==max){
                if(o1==o2){
                    ans=root;
                }else{
                    if(o1>o2){
                        //do nothing
                    }else{
                        //do nothing and ans remains same
                    }
                }
            }else{
                if(o1==o2){
                    ans=root;
                    max=o1;
                }else{
                    if(o1>o2){
                        max=o1;
                        ans=root.left;
                    }else{
                        max=o2;
                        ans=root.right;
                    }
                }
            }
        }
        return Math.max(o1,o2);
    }
}