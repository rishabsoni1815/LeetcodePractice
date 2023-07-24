class Solution {
    public double myPow(double x, int n) {
        long nn=n;double ans=1.0;
        if(nn<0) nn*=-1;
        while(nn>0){
            if(nn%2==0){
                x*=x;
                nn/=2;
            }else{
                ans*=x;
                nn-=1;
            }
        }
        if(n<0) return (1.0/ans);
        else return ans;
    }
}