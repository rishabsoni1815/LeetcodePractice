class Solution {
    public int maxScore(List<List<Integer>> g) {
        //observation lets say go from a->b->c so sum=b-a +c-b => c-a so only last matters so for a[i][j] we dont want total sum of path we just want maximum element in all of the ledft and down neighbours or subgrid from a[i+][j+1] to a[n-1][m-1] and also its next ro and its next down column elements 
        
        int n=g.size(),m=g.get(0).size();
        int a[][]=new int[n][m];
        a[n-1][m-1]=g.get(n-1).get(m-1);
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i+1<n) a[i][j]=Math.max(g.get(i).get(j),a[i+1][j]);
                if(j+1<m) a[i][j]=Math.max(a[i][j],Math.max(g.get(i).get(j),a[i][j+1]));
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i+1<n) ans=Math.max(ans,a[i+1][j]-g.get(i).get(j));
                if(j+1<m) ans=Math.max(ans,a[i][j+1]-g.get(i).get(j));
            }
        }
        return ans;
    }
}