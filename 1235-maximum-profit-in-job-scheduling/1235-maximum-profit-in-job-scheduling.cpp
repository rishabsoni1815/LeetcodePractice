class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        int n = profit.size(), ans = 0;
        vector<vector<int>> v;
        for(int i = 0; i < n; i++)
            v.push_back({startTime[i], endTime[i], profit[i]});
        
        sort(v.begin(), v.end());
        map<int, int> mp;
        
        for(int i = n - 1; i >= 0; i--)
        {
            int tmp = v[i][2];
            auto it = mp.lower_bound(v[i][1]);
            
            if(it != mp.end())
                tmp += it->second;
            
            ans = max(ans, tmp);
            mp[v[i][0]] = ans;
        }
        
        return ans;
    }
};