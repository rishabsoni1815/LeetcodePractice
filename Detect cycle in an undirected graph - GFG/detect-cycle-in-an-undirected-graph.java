// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> g) {
        // Code here
         boolean v[]=new boolean[n];
        boolean ans=true;
        for(int i=0;i<n;i++){
            if(v[i]==true) continue;
            Queue<int []>q=new LinkedList<>();
            q.add(new int[]{i,-1});
            v[i]=true;
            while(!q.isEmpty()){
                int s=q.size();
                for(int j=0;j<s;j++){
                    int c[]=q.poll();
                    int par=c[1];
                    int t=c[0];
                    for(int nei:g.get(t)){
                        if(v[nei]==false){
                            v[nei]=true;
                            q.add(new int[]{nei,t});
                        }else{
                            if(nei!=par){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}