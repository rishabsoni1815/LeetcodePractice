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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>y=new ArrayList<>();
        if(root==null) return y;
        Queue<TreeNode>s=new LinkedList<TreeNode>();
        s.add(root);
        while(!s.isEmpty()){
            int size=s.size();
            ArrayList <Integer>ans=new ArrayList<>();
             for(int i=0;i<size;i++){ 
            TreeNode temp=s.poll();
            ans.add(temp.val);
            if(temp.left!=null) s.add(temp.left);
            if(temp.right!=null) s.add(temp.right);
            
        }
            y.add(0,ans);
        }
        //Collections.reverse(y);
        return y;
    }
}