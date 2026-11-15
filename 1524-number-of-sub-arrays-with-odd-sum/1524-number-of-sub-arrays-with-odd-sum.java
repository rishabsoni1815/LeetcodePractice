class Solution {
    public int numOfSubarrays(int[] a) {
        int o=0,e=1,ans=0,mod=(int)(1e9+7),c=0;
        for(int i=0;i<a.length;i++){
            c+=a[i];
            c%=2;
            if(c==0){
                ans=(ans+o)%mod;
                e++;
            }else{
                ans=(ans+e)%mod;
                o++;
            }
        }
        return ans%mod;
    }
}