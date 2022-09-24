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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>>flist=new ArrayList<>();
        ArrayList<Integer>clist=new ArrayList<>();
        find(root,clist,0,sum,flist);
        return flist;
    }
    void find(TreeNode root,ArrayList<Integer> clist,int csum,int sum, List<List<Integer>>flist){
        if(root==null) return;
        clist.add(root.val);
        csum+=root.val;
        if(root.left==null&&root.right==null&&csum==sum){
           // as clist chnges in recussion as it is passed through refernce 
            // so have to add a duplicate clist in flist
            //new ArrrayList(list) makes a copy of list not changes refernce
            flist.add(new ArrayList(clist));
        }
        find(root.left,clist,csum,sum,flist);
        find(root.right,clist,csum,sum,flist);
        clist.remove(clist.size()-1);
    }
}