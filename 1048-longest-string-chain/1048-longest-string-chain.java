class Solution {
  public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();//as can't strore string as index so map
        Arrays.sort(words, (a, b)->a.length() - b.length());//to check only for smaller 
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }
}