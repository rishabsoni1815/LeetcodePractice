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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];//can use hashmap also
        return preorder(root, arr);
    }
    
    public int preorder(TreeNode root, int[] arr) {
        if(root == null) {
            return 0;
        }
        
        arr[root.val]++;
        if(root.left == null && root.right == null) {
            return isPalindrome(arr) ? 1 : 0;
        }
        
        return preorder(root.left, arr.clone()) + preorder(root.right, arr.clone());
    }
    
    public boolean isPalindrome(int[] arr) {
        // return true if there is atmost one number with odd frequency 
        int odd = 0;
        for(int num: arr) {
            if(num % 2 == 1) {
                odd++;
            }
        }
        if(odd > 1) {
            return false;
        }
        return true;
    }
}