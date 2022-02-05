/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>ans=new ArrayList<>();
        if(root==null) return ans;
           Map<TreeNode, TreeNode> parent = new HashMap();
           dfs(root,null,parent);
           int c=0;
        Queue<TreeNode>q=new LinkedList<>();
        HashSet<TreeNode>h=new HashSet<>();
        h.add(target);
        q.add(target);
        while(q.size()>0){
            int s=q.size();
            if(c==k){
                for(TreeNode r:q){
                    ans.add(r.val);
                }
                    return ans;
            }
            for(int i=0;i<s;i++){
                TreeNode temp=q.poll();
                h.add(temp);
                if(temp.left!=null&&(h.contains(temp.left)==false)) q.add(temp.left);
                if(temp.right!=null&&(h.contains(temp.right)==false)) q.add(temp.right);
                if(parent.get(temp)!=null&&(h.contains(parent.get(temp))==false)) q.add(parent.get(temp));
            }
            c++;
        }
        return ans;
    }
     public void dfs(TreeNode node, TreeNode par,Map<TreeNode, TreeNode> parent) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node,parent);
            dfs(node.right, node,parent);
        }
    }
}