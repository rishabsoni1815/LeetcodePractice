class Solution {
    public int minFlips(int a, int b, int c) {
        // 0,0,0 = 0
        // 0,1,0 = 1
        // 1,0,0 = 1
        // 1,1,0 = 2 
        // 0,0,1 = 1
        // 0,1,1 = 0
        // 1,0,1 = 0
        // 1,1,1 = 0
        int ans=0;
        while(a!=0 || b!=0 || c!=0){
            boolean t1=false,t2=false,t3=false;//true means bit is set (i.e. 1)
            if(a%2!=0) t1=true;
            if(b%2!=0) t2=true;
            if(c%2!=0) t3=true;
            if(t1){
                if(t2){
                    if(t3==false) ans+=2;
                }else{
                    if(t3==false) ans++;
                }
            }else{
                if(t2){
                    if(t3==false) ans++;
                }else{
                    if(t3==true) ans++;
                }
            }
            if(a>0) a=a>>1;
            if(b>0) b=b>>1;
            if(c>0) c=c>>1;
        }
        return ans;
    }
}