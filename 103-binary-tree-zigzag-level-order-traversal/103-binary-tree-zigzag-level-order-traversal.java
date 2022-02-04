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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode>s1=new Stack<>();
        Stack<TreeNode>s2=new Stack<>();// using two as stack feature is LIFO so left's childrne will put their children first and our root's right childs will have to wait ( like dfs ) ---- draw for a test case
        s1.push(root);
          List<Integer>temp=new ArrayList<>();
        while(!s1.isEmpty()||(!s2.isEmpty())){
           temp=new ArrayList<>();
           while(!s1.isEmpty()){
            TreeNode t=s1.pop();
              temp.add(t.val);
             if(t.left!=null) s2.push(t.left);
               if(t.right!=null) s2.push(t.right);
            }
         if(!temp.isEmpty()) ans.add(temp);
            temp=new ArrayList<>();
            while(!s2.isEmpty()){
            TreeNode t=s2.pop();
              temp.add(t.val);
                if(t.right!=null) s1.push(t.right);//right then left coz of the way we want our data ---- draw for a test case
                if(t.left!=null) s1.push(t.left);
            }
           if(!temp.isEmpty()) ans.add(temp);
            
        }
        return ans;
    }
}