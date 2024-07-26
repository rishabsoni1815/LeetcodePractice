class Solution {
    public int findTheCity(int n, int[][] e, int d) {
        int dis[][]=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dis[i],Integer.MAX_VALUE);
        
        for(int i=0;i<e.length;i++){
            dis[e[i][0]][e[i][1]]=e[i][2];
            dis[e[i][1]][e[i][0]]=e[i][2];
        }
        for(int i=0;i<n;i++) dis[i][i]=0;
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE && dis[i][k] + dis[k][j] < dis[i][j]) {//imp as int_max+int_max can go -ve 
                        dis[i][j]=dis[i][k]+dis[k][j];
                    }
                }
            }
        }
        int smallest=Integer.MAX_VALUE,smallestNode=0;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i!=j && dis[i][j]<=d) cnt++;
            }
            if(cnt<=smallest){
                smallest=cnt;
                smallestNode=i;
            }
        }
        return smallestNode;
    }
}