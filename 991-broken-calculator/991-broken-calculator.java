class Solution {
    public int brokenCalc(int s, int t) {
        int ans=0;
        if(t<=s){
            return s-t;
        }
        while(t>s){
            if(t%2!=0){
                ans++;
                t++;
            }else{
                t/=2;
                ans++;
            }
        }
        ans+=s-t;
        return ans;
    }
}