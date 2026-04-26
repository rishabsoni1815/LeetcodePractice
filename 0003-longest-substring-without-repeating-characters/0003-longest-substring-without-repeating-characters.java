class Solution {

    // O(n) sol. as j and i both moved n times
    // int n = s.length(), ans = 0;
    // int i=0,j=0;
    // HashSet<Character>h=new HashSet<>();
    // while(j<n){
    //     char c=s.charAt(j);
    //     if(!h.contains(c)){
    //         h.add(c);
    //         j++;
    //         ans=Math.max(ans,j-i);
    //     }else{
    //         h.remove(s.charAt(i)); 
    //         i++; 
    //     }
    // }
    // return ans;

    //another o(n) using sliding window

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if (map.containsKey(c)) {

                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}