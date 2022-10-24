class Solution {
    public int maxLength(List<String> arr) {
        int[] ch = new int[26];
        Arrays.fill(ch, 0);
        return dfs(arr, 0, ch);
    }
    
    HashMap<String, Integer> memo = new HashMap<>();
    public int dfs(List<String> arr, int idx, int[] ch) {
        if (idx == arr.size()) {
            return 0;
        }
        String key = "" + idx+","+ch.toString();
        if (memo.containsKey(key)) return memo.get(key);
        int result = Integer.MIN_VALUE;
        String s = arr.get(idx);
        boolean flag = true;
        int[] ch1 = new int[26];
        for (int i = 0; i < 26; i++) ch1[i] = ch[i];
        for (int j = 0; j < s.length(); j++) {
            int c = s.charAt(j) - 'a';
            ch1[c]++;
            if (ch1[c] > 1) {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            result = Math.max(result, s.length() + dfs(arr, idx+1, ch1));
        }
        
        result = Math.max(result, dfs(arr, idx+1, ch));
        memo.put(key, result);
        return result;
    }
}