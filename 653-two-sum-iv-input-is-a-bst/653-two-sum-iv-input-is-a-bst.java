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


//  o(n) space
// public class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         Set < Integer > set = new HashSet();
//         return find(root, k, set);
//     }
//     public boolean find(TreeNode root, int k, Set < Integer > set) {
//         if (root == null)
//             return false;
//         if (set.contains(k - root.val))
//             return true;
//         set.add(root.val);
//         return find(root.left, k, set) || find(root.right, k, set);
//     }
// }


//o(h) space  next -> right's eftmoft in bst,  prev-> left's rightmost in bst and then just used what we do in two sum after sorting with two pointers
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true; // true means prev false means next from root
    
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse; 
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        if(reverse == false) pushAll(tmpNode.right);
        else pushAll(tmpNode.left); 
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        while(node != null) {
             stack.push(node);
             if(reverse == true) {
                 node = node.right; 
             } else {
                 node = node.left; 
             }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false; 
        BSTIterator l = new BSTIterator(root, false); //iterator class
        BSTIterator r = new BSTIterator(root, true); 
        
        int i = l.next(); 
        int j = r.next(); 
        while(i<j) {
            if(i + j == k) return true; 
            else if(i + j < k) i = l.next(); 
            else j = r.next(); 
        }
        return false; 
    }
}
