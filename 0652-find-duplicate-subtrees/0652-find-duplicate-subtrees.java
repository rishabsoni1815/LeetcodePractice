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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer>h=new HashMap<>();
        List<TreeNode>ans=new ArrayList<>();
        help(h,root,ans);
        return ans;
    }
    String help(HashMap<String,Integer>h,TreeNode root,List<TreeNode>ans){
      if(root==null) return "";
        String s1=help(h,root.left,ans);
        String s2=help(h,root.right,ans);
        String s=root.val+","+s1+ "," +s2;//idea of this to check not val+s1+s2 as 2  is 24 and 2 is also 24 so make also not s1+val+s2 as inorder for 0 0 null and null 0 0 is same for s1+val+s2 
        if(h.containsKey(s)){             //                                      /             \
            h.put(s,h.get(s)+1);            //                                   4               4
        }else{                             //                             => 2,4,,            => 2,,4 is not same
            h.put(s,1);
        }
        if(h.get(s)==2){
            ans.add(root);
        }
        return s;
    }
}