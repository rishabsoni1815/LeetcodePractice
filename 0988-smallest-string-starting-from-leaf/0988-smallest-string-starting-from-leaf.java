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
    String ans = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }
    
    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String S = sb.toString();
            sb.reverse();

            if (S.compareTo(ans) < 0 || ans.length()==0)
                ans = S;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);//as stringbuilder is not immutable has this had been a string then we dont need this as while doing + new string is made as string are immutable
    }
    
    
    /*
    //greeedy wont work here Consider the test case [4,0,1,1]. In this scenario, a greedy approach would fail to produce the correct result. Similarly, in the case of [25,1,null,0,0,1,null,null,null,0], the expected answer is "ababz", but the greedy solution would result in "abz".
    StringBuilder help(TreeNode root){
        if(root==null) return new StringBuilder();
        if(root.left==null && root.right==null) {
            return new StringBuilder().append((char)(root.val+'a'));
        }
        StringBuilder left=help(root.left);
        StringBuilder right=help(root.right);
        if(left.length()>0 && right.length()>0) {// all this needed as they only want path from leaf to root so if we have a node with only left/rigght child then only node is not considered only the part having child is considered so handled that by checking left.lwngth() and right.length() as in troot==null we have returnwd empty stringbuilder 
            System.out.println(root.val+" "+left+" "+right);
            left.append((char)(root.val+'a'));
            right.append((char)(root.val+'a'));
            if(left.compareTo(right)>0) return right;
            return left;   
        }else{
            if(left.length()>0) {
                left.append((char)(root.val+'a'));
                return left;
            }
            right.append((char)(root.val+'a'));
            return right;
        }
    }
    */
}