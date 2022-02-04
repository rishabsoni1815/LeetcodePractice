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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        q.add(root);
        while(q.size()>0){
            int s=q.size();
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode cur=q.poll();
                temp.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}