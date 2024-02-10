class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int cur=help(i-1,i+1,n,s)+help(i,i+1,n,s);
            ans+=cur;
        }
        return ans;
    }
    int help(int l,int r,int n,String s){
        int ans=0;
        if(r-l>1) ans++;
        while(l>=0 && r<n){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                ans++;
            }else break;
        }
        return ans;
    }
}