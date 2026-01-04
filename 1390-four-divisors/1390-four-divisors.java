class Solution {
    public int sumFourDivisors(int[] a) {
        int ans=0;
        for(int i=0;i<a.length;i++){
            int cnt=count(a[i]);
            if(cnt!=-1) ans+=cnt;
        }
        return ans;
    }
    int count(int a){
        int cnt=0,sum=0;
        for(int i=1;i*i<=a;i++){
            int x=i;
            if(a%x==0) {
                cnt++;
                sum+=x;
                if(a/x != x) {
                    cnt++;
                    sum+=(a/x);
                }
            }
            if(cnt>4) return -1;
        }
        return cnt==4 ? sum : -1;
    }
}