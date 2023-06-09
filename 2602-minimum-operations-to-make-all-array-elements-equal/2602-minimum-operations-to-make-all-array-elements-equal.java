class Solution {
    public List<Long> minOperations(int[] a, int[] q) {
        Arrays.sort(a);
        List<Long>ans=new ArrayList<>();
        long pre[]=new long[a.length];
        pre[0]=a[0];
        for(int i=1;i<a.length;i++){
            pre[i]=pre[i-1]+a[i];
        }
        for(int i=0;i<q.length;i++){
            long x=help(a,q[i],a.length,pre);
            ans.add(x);
        }
        return ans;
    }
    long help(int a[],int q,int n,long pre[]){
        int ans=-1,l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]<q){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        } 
        long add=0L,sub=0L;
        if(ans!=-1){
            add=((long)(ans+1)*q)-pre[ans];
            sub=(pre[n-1]-pre[ans])-((long)(n-ans-1)*q);
        }else{
            sub=pre[n-1]-((long)n*q);
        }
        return add+sub;
    }
}