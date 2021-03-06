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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        TreeNode cur = root;
        // 2 cases - 1) if cur.left is nul add and go to right   2) if not null then check the rightest node of the left subtree if this node's rightis null then connect it to cur and move left else (link already there so break it) make its right as null add cur and go right
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;    //    left<---       
                } else {                 //          |
                    pre.right = null;     //         | 
                    nodes.add(cur.val);//inorder is Left root then right
                    cur = cur.right;   //    right <----------------'
                }                     
            } else {
                nodes.add(cur.val);
                cur = cur.right;
            }
        }
        return nodes;
    }
}