class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a,(x,y)->((x[0]!=y[0])?(x[0]-y[0]):(x[1]-y[1])));
        ArrayList<int []>ans=new ArrayList<>();
        int n=a.length;
        int s=a[0][0];int e=a[0][1];
        int i=0;
        while(i<n){
            s=a[i][0];
            e=a[i][1];
            while(i<n&&e>=a[i][0]){
                e=Math.max(e,a[i][1]);
                i++;
            }
            ans.add(new int[]{s,e});
        }
        int fina[][]=new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            fina[j][0]=ans.get(j)[0];
            fina[j][1]=ans.get(j)[1];
        }
        return fina;
    }
}