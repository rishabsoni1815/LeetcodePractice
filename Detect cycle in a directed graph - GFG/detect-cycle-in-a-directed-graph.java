// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> g) {
        // code here
        boolean v[]=new boolean[n];
        boolean cur[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(v[i]==false){
               if(dfs(i,g,v,cur)==true) return true; 
            }
        }
        return false;
    }
    boolean dfs(int i,ArrayList<ArrayList<Integer>>g,boolean v[],boolean cur[]){
        v[i]=true;
        cur[i]=true;
        for(int nei:g.get(i)){
            if(v[nei]==false){
                if(dfs(nei,g,v,cur)==true) return true;
            }else{
                if(cur[nei]) return true;
            }
        }
        cur[i]=false;
        return false;
    }
}