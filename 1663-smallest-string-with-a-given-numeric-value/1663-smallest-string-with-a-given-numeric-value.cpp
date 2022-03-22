class Solution {
public:
    string getSmallestString(int n, int k) {
     string res = "";
        int i = n;
        while(k>0){
            int remain = k - (i-1);
            
            if(remain > 26){
                res += 'z';
                k = k-26;
            }
            
            else{
                k = k - remain;
                res += ('a' + remain - 1);
               
            }
            
            i--;
        }
        
        reverse(res.begin(), res.end());
        return res;   
    }
};