class pair{
    int a;
    int b;
    int c;
    pair(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
class Solution {//first adding 0th column then will try removing k small elements from min heap last removed will be our ans and will add the next elemeent to right of the same elemtnt a[i][j+1] as that will be just enxt greater to a[i][j] as matrix is sorted row wise
    public int kthSmallest(int[][] a, int k) {
        int n=a.length;
        int m=a[0].length;
        PriorityQueue<pair>q=new PriorityQueue<>((x,y) -> x.a-y.a);
        for(int i=0;i<n;i++){
            q.add(new pair(a[i][0],i,0));
        }
        int ans=0;
        while(k-->0){
            pair temp=q.poll();
            int ii=temp.b;
            int jj=temp.c;
            ans=(temp.a);
            if(jj+1<m) q.add(new pair(a[ii][jj+1],ii,jj+1));
        }
        return ans;
    }
}