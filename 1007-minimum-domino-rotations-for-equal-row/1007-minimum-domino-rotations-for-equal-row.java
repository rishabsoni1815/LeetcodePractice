class Solution {
    public int minDominoRotations(int[] t, int[] b) {
        int n=t.length;
        int cnt=Integer.MAX_VALUE;
        for(int k=1;k<=6;k++){
            int cur=0;boolean f=true;
            for(int i=0;i<n;i++){
                if(t[i]==k){
                    continue;
                }else{
                    if(b[i]==k){
                      cur++;  
                    }else{
                        f=false;
                        break;
                    }
                }
            }
            if(f==true){
                cnt=Math.min(cnt,cur);
            }
        }
        
        for(int k=1;k<=6;k++){
            int cur=0;boolean f=true;
            for(int i=0;i<n;i++){
                if(b[i]==k){
                    continue;
                }else{
                    if(t[i]==k){
                      cur++;  
                    }else{
                        f=false;
                        break;
                    }
                }
            }
            if(f==true){
                cnt=Math.min(cnt,cur);
            }
        }
        
        if(cnt==Integer.MAX_VALUE){
            return -1;
        }else{
            return cnt;
        }
    }
}