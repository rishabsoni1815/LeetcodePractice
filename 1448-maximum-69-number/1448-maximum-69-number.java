class Solution {
    public int maximum69Number (int n) {
        int ans=n,cans=0,tans=0,c=1;
        while(n>0){
            int x=n%10;
            if(x==6){
                if(cans!=0){
                    cans=tans;
                    cans=9*c+cans;
                }else{
                    cans=9*c+cans;
                }
            }else{
                cans=x*c+cans;
            }
            tans=x*c+tans;
            ans=Math.max(ans,cans);
            c*=10;
            n/=10;
        }
        return ans;
    }
}