class Solution {
    public double maxAverageRatio(int[][] a, int e) {
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(help(x,y)));
        int n=a.length;
        double ans=0.0;
        for(int i=0;i<n;i++){
           q.add(new int[]{a[i][0],a[i][1]});
        }
        while(e-->0){
            int c[]=q.poll();
            // System.out.println(c[0]+" "+c[1]);
            q.add(new int[]{c[0]+1,c[1]+1});
        }
        while(q.size()>0){
            int x[]=q.poll();
            ans+=((double)(x[0])/x[1]);
        }
        return ans/n;
    }
    int help(int x[],int y[]){
        double f1=((double)(x[0])/x[1]);
        double nf1=((double)(x[0]+1)/(x[1]+1));
        double d1=nf1-f1;
        
        double f2=((double)(y[0])/y[1]);
        double nf2=((double)(y[0]+1)/(y[1]+1));
        double d2=nf2-f2;
        
        return (d1-d2)>0 ? -1:1 ;
    }
}