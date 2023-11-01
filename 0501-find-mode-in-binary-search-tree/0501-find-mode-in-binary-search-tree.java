class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> values = new ArrayList();
        dfs(root, values);

        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> ans = new ArrayList();

        for (int num : values) {
            if (num == currNum) {
                currStreak++;
            } else {
                currStreak = 1;
                currNum = num;
            }
            
            if (currStreak > maxStreak) {
                ans = new ArrayList();
                maxStreak = currStreak;
            }
            
            if (currStreak == maxStreak) {
                ans.add(num);
            }
        }
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
    
    public void dfs(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        
        // Inorder traversal visits nodes in sorted order
        dfs(node.left, values);
        values.add(node.val);
        dfs(node.right, values);
    }
}