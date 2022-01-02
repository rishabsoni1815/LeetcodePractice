class Solution {
    public int subarraysDivByK(int[] a, int k) {
        int n=a.length;
        int h[]=new int[k];
        int s=0,ans=0;
        h[0]=1;// as subaaray of sum 0 is empty is also there
        for(int i=0;i<n;i++){
            s+=a[i];
            int x=s%k;
            if(x<0) x+=k;
                /*
                checking if s%k is present before or not as if s%k is present before then the array b/w 2 occurances will be divisible by k as 
                (-----------------------------------)
                <----s1--->
                <-----------------s2------->
                let s1=k*m+x;
                s2=k*n+x;   /// +x as we are checking if s%k(x here) has occured before or not
                then s2-s1=k(m-n) which is divisble by k
               */     
                ans+=h[x];
            h[x]++;
        }
        return ans;
    }
}