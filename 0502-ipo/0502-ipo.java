class Solution {
    public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
        int n=p.length;
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=c[i];
            a[i][1]=p[i];
        }
        Arrays.sort(a,(x,y)->(x[0]!=y[0] ? (x[0]-y[0]):(y[1]-x[1])));//sorting based on min capital then max profit
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(y[1]-x[1]));//max heap acc to max profit
        int i=0;
        while(i<n || k>0){//imp is k>0 as i maybe finished but queu is still >0 size
            while(i<n && a[i][0]<=w){
                q.add(new int[]{a[i][0],a[i][1]});
                i++;
            }
            if(q.size()==0 || k==0) break;//as no element to be added now
            if(k>0) {
                int curp=q.poll()[1];
                w+=curp;
                k--;
            }
        }
        return w;
    }
}