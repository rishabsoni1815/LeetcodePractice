class Solution {
    public int rangeSum(int[] a, int n, int l, int r) {
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(x[0]-y[0]));
        for(int i=0;i<n;i++){
            q.add(new int[]{a[i],i});
        }
        int i=0,ans=0,mod=(int)(1e9+7);
        while(i<r){
            int cur[]=q.poll();
            if(i>=(l-1)){//as l is 1 indexed
                ans=(ans%mod + cur[0]%mod)%mod;
            }
            if(cur[1]+1<n){
                q.add(new int[]{cur[0]+a[cur[1]+1],cur[1]+1});
            }
            i++;
        }
        return ans;
    }
}