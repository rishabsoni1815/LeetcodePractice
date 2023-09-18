class Solution {
    public int[] kWeakestRows(int[][] a, int k) {
        int n=a.length;
        int m=a[0].length;
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(x[1]==y[1]?(y[0]-x[0]):(y[1]-x[1])));//max heap as needed k minimum and 0->index,1->freq of 1
        for(int i=0;i<n;i++){
            int c=find(a[i],m)+1;
            q.add(new int[]{i,c});
            if(q.size()>k){
                q.poll();
            }
        }
        int ans[]=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=q.poll()[0];
        }
        return ans;
    }
    int find(int a[],int n){
        int l=0,r=n-1,ans=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]==1){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ans;
    }
}