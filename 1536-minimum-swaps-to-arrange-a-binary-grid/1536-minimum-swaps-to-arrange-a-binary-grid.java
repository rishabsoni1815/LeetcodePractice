class Solution {
    public int minSwaps(int[][] a) {
        int n=a.length;
        int z[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(a[i][j]==1) break;
                z[i]++;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int j=i;
            while(j<n && z[j]<(n-i-1)){
                j++;
            }
            if(j>=n) return -1;
            ans+=((j-i));
            while(j>i){
                swap(j,j-1,z);
                j--;
            }
        }
        return ans;
    }
    static void swap(int x,int y,int a[]){
        int t=a[x];
        a[x]=a[y];
        a[y]=t;
    }
}