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
    public TreeNode addOneRow(TreeNode root, int val, int d) {
        return help(root,val,d);
    }
    TreeNode help(TreeNode root, int val, int d){
        if(root==null) return null;
        if(d==1){
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }
        if((d-1)==1){//or d==2
            TreeNode tleft=root.left,tright=root.right;
            root.left=new TreeNode(val,tleft,null);
            root.right=new TreeNode(val,null,tright);
            return root;
        }
        addOneRow(root.left,val,d-1);
        addOneRow(root.right,val,d-1);
        return root;
    }
}
/*
/bfs -> traverse till d-2 then queue has d-1 ones so add val to these now
  public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < d-2; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode t = queue.poll();
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
        }
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            TreeNode tmp = t.left;
            t.left = new TreeNode(v);
            t.left.left = tmp;
            tmp = t.right;
            t.right = new TreeNode(v);
            t.right.right = tmp;
        }
        return root;
    }

*/