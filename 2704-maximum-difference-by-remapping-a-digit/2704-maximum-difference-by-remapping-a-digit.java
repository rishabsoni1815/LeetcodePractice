class Solution {
    public int minMaxDifference(int a) {
        int t=a,max=0,min=0,c=0,z=0,l=0;
        while(t>0){
            int x=t%10;
            if(x<9) c=x;
            t/=10;
            l=x;
        }
        t=a;
        while(t>0){
            int x=t%10;
            if(x==c){
                max+=9*Math.pow(10,z);
            }else{
                max+=x*Math.pow(10,z);
            }
            
            if(x==l){
                if(x==l) min+=0*Math.pow(10,z);
            }else{
                min+=x*Math.pow(10,z);
            }
            t/=10;
            z++;
        }
        return max-min;
    }
}