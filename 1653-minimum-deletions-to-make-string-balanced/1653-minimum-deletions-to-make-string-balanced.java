class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int ra[]=new int[n];
        if(s.charAt(n-1)=='a') ra[n-1]=1;
        
        for(int i=n-2;i>=0;i--){
            ra[i]=ra[i+1];
            if(s.charAt(i)=='a') ra[i]++;
        }
        
        
        int ans=n,lb=0;
        for(int i=0;i<n;i++){
            int cnt=0;
            if(s.charAt(i)=='b') lb++;
            if(s.charAt(i)=='b'){
                cnt=lb-1;
                cnt+=(ra[i]);
            }else{
                cnt=lb;
                cnt+=(ra[i]-1);
            }
            ans=Math.min(ans,cnt);
        }
        return ans;
    }
}