class Solution {
    public void flatten(TreeNode root) {
        help(root);
    }

    TreeNode help(TreeNode root) {
        if (root == null) return null;

        TreeNode leftTail = help(root.left);
        TreeNode rightTail = help(root.right);

        if(leftTail!=null){
            leftTail.right=root.right;
        }
        if(root.left!=null) root.right=root.left;
        root.left=null;
        if(rightTail!=null) return rightTail;
        if(leftTail!=null) return leftTail;
        return root;
    }
}
