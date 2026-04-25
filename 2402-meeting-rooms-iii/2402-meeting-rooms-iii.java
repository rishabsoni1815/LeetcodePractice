class Solution {
    public int mostBooked(int n, int[][] a) {
        if(n>=a.length) return 0;
        Arrays.sort(a,(x,y)->(x[0]-y[0]));
        PriorityQueue<int []>q=new PriorityQueue<>((x,y)->(x[1]==y[1]? (x[2]-y[2]):(x[1]-y[1])));//start,end,room_no
        int freq[]=new int[n];
        int p=0;
        for(int i=0;i<a.length;i++){
            if(q.size()<n){
                q.add(new int[]{a[i][0],a[i][1],p});
                freq[p]++;
                p++;
            }else{
                int c[]=q.poll();
                int s=c[1];
                int e=s+a[i][1]-a[i][0];
                q.add(new int[]{s,e,c[2]});
                freq[c[2]]++;
            }
        }
        int ans=0,max=0;
        for(int i=0;i<n;i++){
            if(freq[i]>max){
                max=freq[i];
                ans=i;
            }
        }
        return ans;
    }
}