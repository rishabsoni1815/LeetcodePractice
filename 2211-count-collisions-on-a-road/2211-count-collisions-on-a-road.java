class Solution {
    public int countCollisions(String s) {
        char c[]=s.toCharArray();
        int n=s.length();
        int ans=0;
        int k=n-1;
        for(int i=n-1;i>=0;i--){
            if(c[i]=='R'){
                k--;
            }else{
                break;
            }
        }
        if(k==0) return 0;
        int i=0;
        while(i<k){
            if(c[i]=='R'){
                char t=c[i+1];
                if(t=='L'){
                    ans+=2;
                    c[i+1]='S';
                }else if(t=='S'){
                    ans++;
                }else{
                    ans++;//as RRRS then ans+=3 this is sure as we have removed all R from last
                }
            }else if(c[i]=='S'){
                char t=c[i+1];
                if(t=='L'){
                    ans++;
                    c[i+1]='S';
                }
            }
            i++;
        }
        return ans;
    }
}