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
    int k=0;
    public TreeNode buildTree(int[] pre, int[] in) {
        int n=in.length;
        k=0;
        HashMap<Integer,Integer>h=new HashMap<>();
        for(int i=0;i<n;i++){
            h.put(in[i],i);
        }
        return make(pre,0,n-1,h);
    }
    TreeNode make(int pre[],int i,int j,HashMap<Integer,Integer>h){
        if(i>j) return null;
        int cur=pre[k];
        k++;
        TreeNode c=new TreeNode(cur);
        c.left=make(pre,i,h.get(cur)-1,h);
        c.right=make(pre,h.get(cur)+1,j,h);
        return c;
    }
}