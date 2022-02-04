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
    List<Location> locations=null;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        locations=new ArrayList<>();
        dfs(root,0,0);
        Collections.sort(locations);
        int x=locations.get(0).x;
        result.add(new ArrayList<>());
        
        for(Location l: locations){
            if(x!=l.x){
                x=l.x;
                result.add(new ArrayList<>());
            }
            result.get(result.size()-1).add(l.val);
        }
        return result;
    }
    
    private void dfs(TreeNode root,int x,int y){
        if(root!=null){
            locations.add(new Location(x,y,root.val));
            dfs(root.left,x-1,y-1);
            dfs(root.right,x+1,y-1);
        }
    }
    
    class Location implements Comparable<Location>{
        int x,y,val;
        
        Location(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
        
        public int compareTo(Location a){
            if(this.x!=a.x){
                if(this.x<a.x) return -1;
                return 1;
            }
            if(this.y!=a.y){// as going down is -y
                if(this.y>a.y) return -1;
                return 1;
            }
            else {
               if(this.val<a.val) return -1;
                return 1;
            }
        }
    }
}