class Solution {
    public boolean canMakeArithmeticProgression(int[] a) {
        int n=a.length;
        int min=a[0],max=a[0];
        for(int i=0;i<n;i++){
            min=Math.min(min,a[i]);
            max=Math.max(max,a[i]);
        }

        int d=0,x=max-min;
        if(x%(n-1)==0){
            d=x/(n-1);
        }else{
            return false;
        }        
        for(int i=0;i<n;){
            int y=min+(i*d);
            if(a[i]!=y){
                int ni=-1,nx=a[i]-min;
                if(nx%d==0){
                    ni=nx/d;
                    if(ni<i || a[ni]==a[i]) return false;//prev are correct so cant be possible also if correct element already present this means duplicate present 
                    int u=a[ni];
                    a[ni]=a[i];
                    a[i]=u;
                }else return false;
            }else{
                i++;
            }
        }
        return true;
    }
}