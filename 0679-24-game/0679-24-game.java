class Solution {
    int ans=0;
    public boolean judgePoint24(int[] aa) {
        double a[]=new double[4];
        for(int i=0;i<4;i++){
            a[i]=aa[i];
        }
        boolean v[]=new boolean[4];
        return help(a,v);
    }
    boolean help(double a[],boolean v[]){
        int tc=0;
        double tans=0;
        for(int kk=0;kk<4;kk++){
            if(v[kk]==false) {
                tc++;
                tans=a[kk];
            }
        }
        if(tc==1) {
            return Math.abs(tans - 24.0) <= 1e-6;
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i!=j && v[i]==false && v[j]==false){
                    v[i]=true;
                    double t=a[j];

                    a[j]=a[i]*a[j];
                    if(help(a,v)) return true;
                    a[j]=t;

                    a[j]=a[i]+a[j];
                    if(help(a,v)) return true;
                    a[j]=t;
                    
                    a[j]=a[i]-a[j];
                    if(help(a,v)) return true;
                    a[j]=t;
                    
                    if(a[j]!=0) a[j]=a[i]/a[j];
                    if(help(a,v)) return true;
                    a[j]=t;
                    
                    a[j]=a[j]-a[i];
                    if(help(a,v)) return true;
                    a[j]=t;
                    
                    if(a[i]!=0) a[j]=a[j]/a[i];
                    if(help(a,v)) return true;
                    a[j]=t;

                    v[i]=false;
                }
            }
        }
        return false;
    }
}