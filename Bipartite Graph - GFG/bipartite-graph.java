// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int n, ArrayList<ArrayList<Integer>>g)
    {
        boolean v[]=new boolean[n];
        int col[]=new int[n];
        Arrays.fill(col,-1);
        // Code here
        for(int i=0;i<n;i++){
            if(v[i]==false){
                Queue<Integer>q=new LinkedList<>();
                q.add(i);
                v[i]=true;
                col[i]=0;
                while(!q.isEmpty()){
                    int t=q.poll();
                    for(int nei:g.get(t)){
                        if(v[nei]==false){
                            v[nei]=true;
                            q.add(nei);
                            col[nei]=1-col[t];
                        }
                        else{
                            if(col[nei]==col[t]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}