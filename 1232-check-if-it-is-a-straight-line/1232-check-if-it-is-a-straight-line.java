class Solution {
    public boolean checkStraightLine(int[][] a) {
        int n=a.length;
        int s1=0,s2=0;
        for(int i=1;i<n;i++){
            int x=(a[i][0]-a[i-1][0]);
            int y=(a[i][1]-a[i-1][1]);
            int g=gcd(x,y);
            // System.out.println(x+" "+y+" "+s1+" "+s2+" "+g);
            x/=g;y/=g;
            if(s1==0 && s2==0){
                s1=x;s2=y;
            }else{
                if(x!=s1||y!=s2) return false;
            }
        }
        return true;
    }
    
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}