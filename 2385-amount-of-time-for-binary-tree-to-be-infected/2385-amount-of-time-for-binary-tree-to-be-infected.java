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
    public int amountOfTime(TreeNode root, int k) {
        HashMap<TreeNode,TreeNode>p=new HashMap<>();
        dfs(root,null,p);
        Queue<TreeNode>q=new LinkedList<>();
        HashSet<TreeNode>v=new HashSet<>();
        int ans=0;
        TreeNode st=help(root,k);//as nodes are unique we don't need this we can directly work with root.val and make queue of Integer
        q.add(st);
        v.add(st);
        while(q.size()>0){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode t=q.poll();
                if(t.left!=null && v.contains(t.left)==false){
                    v.add(t.left);
                    q.add(t.left);
                }
                if(t.right!=null && v.contains(t.right)==false){
                    v.add(t.right);
                    q.add(t.right);
                }
                if(p.get(t)!=null && v.contains(p.get(t))==false){
                    v.add(p.get(t));
                    q.add(p.get(t));
                }
            }
            ans++;
        }
        return ans-1;
    }
    TreeNode help(TreeNode root,int t){
        if(root==null) return null;
        if(root.val==t) return root;
        TreeNode l=help(root.left,t);
        if(l!=null) return l;
        TreeNode r=help(root.right,t);
        return r;
    }
    void dfs(TreeNode root,TreeNode par,HashMap<TreeNode,TreeNode>p){
        if(root==null) return;
        p.put(root,par);
        dfs(root.left,root,p);
        dfs(root.right,root,p);
    }
}