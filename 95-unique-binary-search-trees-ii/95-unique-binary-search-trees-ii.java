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


//recurssive but i,j may repeat

// class Solution {
//     public List<TreeNode> generateTrees(int n) {
//        return help(1,n);
//     }
//     List<TreeNode> help(int i,int j){
//         List<TreeNode>ans=new ArrayList<>();
//         if(i>j){
//             ans.add(null);
//             return ans;
//         }
//         for(int k=i;k<=j;k++){
//             List<TreeNode>left=help(i,k-1);
//             List<TreeNode>right=help(k+1,j);
//             for(TreeNode l:left){
//                 for(TreeNode r:right){
//                     TreeNode root=new TreeNode(k);
//                     root.left=l;root.right=r;
//                     ans.add(root);
//                 }
//             }
//         }
//         return ans;
//     }
// }

//dp memoising i and j values
class Solution {
    public List<TreeNode> generateTrees(int n) {
        HashMap<String,List<TreeNode>>dp=new HashMap<>();
       return help(1,n,dp);
    }
    List<TreeNode> help(int i,int j,HashMap<String,List<TreeNode>>dp){
        List<TreeNode>ans=new ArrayList<>();
        if(i>j){
            ans.add(null);
            return ans;
        }
        String cur=i+"-"+j;
        if(dp.containsKey(cur)) return dp.get(cur);
        for(int k=i;k<=j;k++){
            List<TreeNode>left=help(i,k-1,dp);
            List<TreeNode>right=help(k+1,j,dp);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(k);
                    root.left=l;root.right=r;
                    ans.add(root);
                }
            }
        }
        dp.put(cur,ans);
        return ans;
    }
}