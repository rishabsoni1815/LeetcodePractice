class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int n=s.length();
        int l=0,r=n,ans=0;
        while(l<=r){
            int m=(l+(r-l)/2);
            if(help(s,n,k,m,true) || help(s,n,k,m,false)){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return ans;
    }
    boolean help(String s,int n,int k,int m,boolean f){
        int x=0,i=0;
        while(i<n){
            if(f==true && s.charAt(i)=='F'){
                x++;
            }else if(f==false && s.charAt(i)=='T'){
                x++;
            }
            if(i==(m-1) && x<=k) return true;
            if(i>=m){
                if(s.charAt(i-m)=='T' && f==false) x--;
                if(s.charAt(i-m)=='F' && f==true) x--;
                if(x<=k) return true;
            }
            i++;
        }
        return false;
    }
}