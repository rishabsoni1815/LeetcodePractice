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

class BSTIterator {
    Stack<TreeNode>s=new Stack<>();
    public BSTIterator(TreeNode root) {
        s=new Stack<>();
        while(root!=null){//getting the smallest no.
            s.add(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode cur=s.pop();
        TreeNode temp=cur.right; //right of cur
        if(temp!=null){//if right exists
            while(temp!=null){//putting all left of this (pop's right) in stack so tha s.pop() is always min 
                s.add(temp);
                temp=temp.left;
            }
        }
        return cur.val;//return s.pop() ( initial stack before putting right's all left)
    }
    
    public boolean hasNext() {
        return s.size()>0;
    }
}

/**  
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */