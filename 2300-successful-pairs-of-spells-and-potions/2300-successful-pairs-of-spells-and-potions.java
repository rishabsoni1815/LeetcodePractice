class Solution {
    public int[] successfulPairs(int[] s, int[] p, long k) {
        Arrays.sort(p);
        int n=s.length;
        int m=p.length;
        for(int i=0;i<n;i++){
            int x=help(s[i],p,k,n,m);
            s[i]=x;
        }
        return s;
    }
    int help(int s,int p[],long k,int n,int m){
        int ans=m,i=0,j=m-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if((p[mid]*(long)s)>=k){
                ans=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return m-ans;
    }
}