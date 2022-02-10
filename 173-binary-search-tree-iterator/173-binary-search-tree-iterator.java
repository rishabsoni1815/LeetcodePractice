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

// o(n) space
// class BSTIterator {
//         void help(TreeNode root,ArrayList<TreeNode>a){
//             if(root==null) return;
//             help(root.left,a);
//             a.add(root);
//             help(root.right,a);
                
//         }
//     ArrayList<TreeNode>a=new ArrayList<>();
//     int i=-1;
//     public BSTIterator(TreeNode root) {
//         help(root,a);
//     }
    
//     /** @return the next smallest number */
//     public int next() {
      
//         return a.get(++i).val;
//     }
    
//     /** @return whether we have a next smallest number */
//     public boolean hasNext() {
//         if(i+1<a.size()) return true;
//         return false;
//     }
// }


//o(h) h is height 
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */