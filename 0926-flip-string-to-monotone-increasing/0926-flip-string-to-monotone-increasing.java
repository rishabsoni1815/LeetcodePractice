class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int p[]=new int[n];
        if(s.charAt(0)=='1') p[0]=1;
        for(int i=1;i<n;i++){
            p[i]=p[i-1];
            if(s.charAt(i)=='1') p[i]++;
        }
        int ans=Math.min(p[n-1],n-p[n-1]);//all 1,all0
        for(int i=0;i<n;i++){
            int l=0;
            if(i!=0) l=p[i-1];//means this i is the first 1 of series "000...11111"
            int totOne=p[n-1];
            int r=(n-i-1-(totOne-p[i]));
            if(s.charAt(i)=='0') r++;
            ans=Math.min(ans,l+r);
        }
        return ans;
    }
}