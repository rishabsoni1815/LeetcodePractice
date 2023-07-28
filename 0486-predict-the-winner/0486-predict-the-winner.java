class Solution {
    public boolean PredictTheWinner(int[] a) {
        int n=a.length;
        int s=0;
        for(int u:a) s+=u;
        int y=help(0,n-1,a,0);
        System.out.println(y+" ans");
        if(2*y>=s) return true;
        return false;
        
    }
    int help(int i,int j,int a[],int b){
        if(i>j) return 0;
        int x=a[i]+Math.min(help(i+2,j,a,1-b),help(i+1,j-1,a,1-b));
        int y=a[j]+Math.min(help(i,j-2,a,1-b),help(i+1,j-1,a,1-b));
        return Math.max(x,y);
    }
}