class Solution {
    public int timeRequiredToBuy(int[] s, int k) {
        int ans=0;
        for(int i=0;i<s.length;i++){
            if(i<=k) ans+=Math.min(s[k],s[i]);
            else ans+=Math.min(s[k]-1,s[i]);//as if k has got s[k] there turn wont com after s[k]-1 as the game stops there
        }
        return ans;
    }
}