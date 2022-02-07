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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key<root.val){
            root.left=deleteNode(root.left,key);
            return root;
        }else if(key>root.val){
             root.right=deleteNode(root.right,key);
            return root;
        }else{
            if(root.left!=null&&root.right!=null){
                TreeNode t=root.left;//finding root's left's rightest child which will be the greatest of all smaller elements than root
                 while(t.right!=null){
                     t=t.right;
                 }
                root.val=t.val;
                root.left=deleteNode(root.left,t.val);//now delete t.val as there will be now 2 root's left's righest child
                return root;
            }else if(root.left!=null){
                return root.left;
            }else if(root.right!=null){
                return root.right;
            }else{
                return null;
            }
        }
    }
}