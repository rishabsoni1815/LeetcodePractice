class Solution {
    public int[] sumEvenAfterQueries(int[] a, int[][] q) {
        int n=a.length;
        int sum=0;
        for(int i=0;i<n;i++){
           if(a[i]%2==0) sum+=a[i];
        }
        int m=q.length;
        int ans[]=new int[m];
        for(int i=0;i<m;i++){
            int idx=q[i][1];
            int val=q[i][0];
            if(val%2==0){
                if(a[idx]%2==0) {
                    a[idx]+=val;
                    sum+=val;
                }else{
                    a[idx]+=val;
                }
            }else{
                if(a[idx]%2==0){
                    sum-=a[idx];
                    a[idx]+=val;
                }else{
                    a[idx]+=val;
                    sum+=a[idx];
                }
            }
            ans[i]=sum;
        }
        return ans;
    }
}