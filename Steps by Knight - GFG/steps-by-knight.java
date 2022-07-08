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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends

class Coordinates{
    int x;
    int y;
    int dist;
    Coordinates(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
class Solution {
    // method of using dis as ans 
    public int minStepToReachTarget(int source[], int target[], int N) {
        boolean visited[][]=new boolean[N+1][N+1];
        int dx[]={-2,-2,-1,-1,1,1,2,2};
        int dy[]={-1,1,-2,2,-2,2,-1,1};
        Queue<Coordinates> q= new LinkedList<>();
        q.add(new Coordinates(source[0],source[1],0));
        int ans=0;
        while(!q.isEmpty()){
            int s=q.size();
            for(int ii=0;ii<s;ii++){
                Coordinates curr=q.remove();
                if(curr.x==target[0]&&curr.y==target[1]){
                    return ans;
                }
                for(int i=0;i<8;i++){
                    int x=curr.x+dx[i];
                int y=curr.y+dy[i];
                    if(isSafe(x,y,N)&&!visited[x][y]){
                        visited[x][y]=true;
                        q.add(new Coordinates(x,y,curr.dist+1));
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    
    public boolean isSafe(int x,int y,int n){
        return x>=1&&x<=n&&y>=1&&y<=n;
    }
    
}
