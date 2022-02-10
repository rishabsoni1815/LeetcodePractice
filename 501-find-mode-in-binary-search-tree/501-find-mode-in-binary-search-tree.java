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
    static int maxFreq = 0, currFreq = 0, precursor = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        maxFreq = 0; currFreq = 0; precursor = Integer.MIN_VALUE;
        ArrayList<Integer>ans=new ArrayList<>();
        inorderTraversal(root,ans);
        int a[]=new int[ans.size()];
        for(int i=0;i<a.length;i++)a[i]=ans.get(i);
        return a;
    }
    static void inorderTraversal(TreeNode root,ArrayList<Integer>res){
         if (root == null) return; // Stop condition
        inorderTraversal(root.left,res); // Traverse left subtree
        if (precursor == root.val) currFreq++;
        else currFreq = 1;
        if (currFreq > maxFreq)
        {// Current node value has higher frequency than any previous visited
            res.clear();
            maxFreq = currFreq;
            res.add(root.val);
        }
        else if (currFreq == maxFreq)
        {// Current node value has a frequency equal to the highest of previous visited
            res.add(root.val);
        }
        precursor = root.val; // Update the precursor
        inorderTraversal(root.right,res); // Traverse right subtree
    }
}