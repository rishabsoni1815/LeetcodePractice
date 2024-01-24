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
    public int pseudoPalindromicPaths (TreeNode root) {
        int h[]=new int[10];
        return dfs(root,h);
    }
    int dfs(TreeNode root,int h[]){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            h[root.val]++;
            int e=0,o=0;
            for(int i=1;i<10;i++){
                if(h[i]>0){
                    if(h[i]%2!=0) o++;
                }
            }
            h[root.val]--;
            if(o>1) return 0;
            return 1;
        }
        h[root.val]++;
        int x=dfs(root.left,h)+dfs(root.right,h);
        h[root.val]--;
        return x;
    }
}