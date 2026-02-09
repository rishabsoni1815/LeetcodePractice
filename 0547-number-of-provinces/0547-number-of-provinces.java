class Solution {
    public int findCircleNum(int[][] a) {
        int ans=a.length;
        Dsu dsu=new Dsu(a.length);
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a[i].length;j++){
                if(a[i][j]==1){
                    if(dsu.add(i,j)==true) ans--; 
                }
            }
        }
        return ans;
    }
    class Dsu{
        int n;
        int p[];
        int r[];
        Dsu(int n){
            p=new int[n];
            for(int i=0;i<n;i++) p[i]=i;
            r=new int[n];
        }
        int findParent(int x){
            if(p[x]==x) return x;
            return p[x]=findParent(p[x]);
        }
        boolean add(int x,int y){
            int p1=findParent(x);
            int p2=findParent(y);
            if(p1==p2) return false;
            if(r[p1]>r[p2]){
                p[p2]=p1;
            }else if(r[p2]>r[p1]){
                p[p1]=p2;
            }else{
                p[p1]=p2;
                r[p2]++;
            }
            return true;
        }
    }
}