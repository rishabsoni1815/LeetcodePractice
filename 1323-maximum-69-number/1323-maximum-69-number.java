class Solution {
    public int maximum69Number (int n) {
        int i=0,x=n,ans=-1;
        while(x>0){
            if(x%10==6) {
                ans=i;
            }
            i++;
            x/=10;
        }
        if(ans==-1) return n;
        int y=(int)Math.pow(10,ans);
        n-=(6*y);
        n+=(9*y);
        return n;
    }
}