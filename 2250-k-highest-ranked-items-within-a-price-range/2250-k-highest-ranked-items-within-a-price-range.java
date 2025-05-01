class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] a, int[] p, int[] s, int k) {
        int n=a.length;
        int m=a[0].length;
        int dirx[]={1,-1,0,0};
        int diry[]={0,0,1,-1};
        List<List<Integer>>ans=new ArrayList<>();
        Queue<int []>q=new LinkedList<>();
        boolean vis[][]=new boolean[n][m];
        q.add(new int[]{s[0],s[1]});
        vis[s[0]][s[1]]=true;
        if(a[s[0]][s[1]]>=p[0] && a[s[0]][s[1]]<=p[1]){
                List<Integer>temp=List.of(s[0],s[1]);
                ans.add(temp);
        }
        while(q.size()>0){
            if(ans.size()==k) return ans;
            int cs=q.size();
            PriorityQueue<int []>pq=new PriorityQueue<>((u,v)->((u[0]!=v[0]) ? (u[0]-v[0]):((u[1]!=v[1]) ? (u[1]-v[1]):(u[2]-v[2]))));
            while(cs-->0){
                int c[]=q.poll();
                for(int ii=0;ii<4;ii++){
                    int nx=c[0]+dirx[ii];
                    int ny=c[1]+diry[ii];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && a[nx][ny]!=0 && vis[nx][ny]==false){
                        vis[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                        if(a[nx][ny]>=p[0] && a[nx][ny]<=p[1]) pq.add(new int[]{a[nx][ny],nx,ny});
                    }
                }
            }
            while(pq.size()>0){
                int cur[]=pq.poll();
                List<Integer>temp=List.of(cur[1],cur[2]);
                ans.add(temp);
                if(ans.size()==k) return ans;
            }
        }
        return ans;
    }
}