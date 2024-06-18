class Solution {
    public int maxProfitAssignment(int[] d, int[] p, int[] w) {
        int n=d.length,m=w.length;
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=d[i];
            a[i][1]=p[i];
        }
        Arrays.sort(a,(x,y)->(x[0]==y[0])?(y[1]-x[1]):(x[0]-y[0]));//sort by distance then price dec/asc doesnt matter
        int max[]=new int[n];//prefix max profit
        for(int i=0;i<n;i++){
           max[i]=a[i][1];
            if(i-1>=0) max[i]=Math.max(max[i],max[i-1]);
        }
        int ans=0;
        for(int i=0;i<m;i++){
            int x=findLargestIndex(a,w[i]);//finding largest element index (d[i]'s i) <=w[i]
            if(x!=-1){
                ans+=max[x];
            }
        }
        return ans;
    }
    int findLargestIndex(int a[][],int x){
        int l=0,r=a.length-1,ans=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m][0]<=x){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ans;
    }
}