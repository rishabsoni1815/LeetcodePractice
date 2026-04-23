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
    public TreeNode sortedArrayToBST(int[] a) {
        int n=a.length;
        return help(a,0,n-1);
    }
    TreeNode help(int a[],int i,int j){
        if(i>j) return null;
        if(j==i) return new TreeNode(a[i]);
        int mid=(i+j)/2;
        TreeNode cur=new TreeNode(a[mid]);
        cur.left=help(a,i,mid-1);
        cur.right=help(a,mid+1,j);
        return cur;
    }
}
