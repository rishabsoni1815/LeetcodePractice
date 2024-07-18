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
    int ans=0;
    public int countPairs(TreeNode root, int d) {
        dfs(root,d);
        return ans;
    }
    HashMap<Integer,Integer> dfs(TreeNode root,int d){
        HashMap<Integer,Integer>a=new HashMap<>();
        if(root==null) return a;
        
        a.put(1,1);
        if(root.left==null && root.right==null) return a;
        
        HashMap<Integer,Integer> l=dfs(root.left,d);
        HashMap<Integer,Integer> r=dfs(root.right,d);

        for(int k1:l.keySet()){
            for(int k2:r.keySet()){
                if((k1+k2)<=d){
                    ans+=(l.get(k1)*r.get(k2));
                }
            }
        }
        
        HashMap<Integer,Integer>p=new HashMap<>();
        for(int k1:l.keySet()){
            if(k1+1<=d) {
                if(p.containsKey(k1+1)){
                    p.put(k1+1,p.get(k1+1)+l.get(k1));
                }else{
                    p.put(k1+1,l.get(k1));
                }
            }
        }
        for(int k2:r.keySet()){
            if(k2+1<=d) {
                if(p.containsKey(k2+1)){
                    p.put(k2+1,p.get(k2+1)+r.get(k2));
                }else{
                    p.put(k2+1,r.get(k2));
                }
            }
        }
        return p;
    }
}