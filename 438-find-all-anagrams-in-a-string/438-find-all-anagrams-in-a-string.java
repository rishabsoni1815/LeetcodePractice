class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return ans;
        int h[]=new int[26];
        for(int i=0;i<p.length();i++){
            h[p.charAt(i)-'a']++;
        }
        int l=0,r=0,c=p.length();
        while(r<s.length()){
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
            if(h[s.charAt(r)-'a']>=1){
                c--;
            }
            h[s.charAt(r)-'a']--;
            r++;
        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
            if(c==0){
                ans.add(l);
            }
        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if((r-l) == p.length()){
                if(h[s.charAt(l)-'a']>=0){
                    c++;
                }
                h[s.charAt(l)-'a']++;
                l++;
            }
        }
        return ans;
    }
}