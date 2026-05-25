class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> mp ; // char , freq
        int n= s.length();
        int l=0;
        int r=0;
        int ans=0;
        while(r<n)
        {
            if(mp.find(s[r])!=mp.end())
            {
                mp.erase(s[l]);
                l++;
            }
            else{
            mp[s[r]]++;
            ans =max(ans,r-l+1);
            r++;
            }
        }
        return ans;
    }
};