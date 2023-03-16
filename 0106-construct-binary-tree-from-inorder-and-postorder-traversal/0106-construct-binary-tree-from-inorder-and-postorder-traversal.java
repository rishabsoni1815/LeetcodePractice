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
     /*
    
    Say we have 2 arrays, Post and IN.
Postorder traversing implies that Post[n-1] is the root node.
Then we can find this Post[n-1] in IN, say it's IN[5].//using map
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it 
    
    */
    int ps=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        ps=postorder.length-1;
        return build(postorder,inorder,map,0,inorder.length-1);
        
    }
    TreeNode build(int p[],int i[],Map<Integer,Integer>map,int is,int ie){
        if(ie<is){
            return null;
        }
        TreeNode root=new TreeNode(p[ps]);
        
        int mid=map.get(p[ps]);
        ps--;
        
        root.right=build(p,i,map,mid+1,ie);//postorder so building right first as ps-- doing so right first
        root.left=build(p,i,map,is,mid-1);
        return root;
    }
}