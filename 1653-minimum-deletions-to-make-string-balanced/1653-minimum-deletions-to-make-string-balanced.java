class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int ra=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') ra++;        
        }
        
        int ans=n,lb=0;
        for(int i=0;i<n;i++){
            int cnt=0;
            if(s.charAt(i)=='b') lb++;
            if(s.charAt(i)=='a') ra--;
            if(s.charAt(i)=='b'){
                cnt=lb-1;
                cnt+=ra;
            }else{
                cnt=lb;
                cnt+=ra;
            }
            ans=Math.min(ans,cnt);
        }
        return ans;
    }
}