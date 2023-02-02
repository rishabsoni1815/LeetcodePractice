class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < 26; i++) {
            orders[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].length() > words[i].length() && words[i - 1].startsWith(words[i])) {
                return false;
            } else {
                int len = Math.min(words[i - 1].length(), words[i].length());
                for (int j = 0; j < len; j++) {
                    int prev = orders[words[i - 1].charAt(j) - 'a'];
                    int curr = orders[words[i].charAt(j) - 'a'];
                    if (prev > curr) {
                        return false;
                    } else if (prev < curr) {
                        break;
                    }
                }
            }
        }
        return true;
    }
}