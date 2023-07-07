class Solution {
    //we can run sliding window on finding max length for all T and F separately return max
    public int maxConsecutiveAnswers(String s, int k) {
        int n=s.length();
        return Math.max(help(s,n,k,true),help(s,n,k,false));
    }
    int help(String s,int n,int k,boolean f){
        int j=0,i=0,max=0;
        while(i<n){
                if(s.charAt(i)=='F' && f==true){
                    k--;
                }else if(s.charAt(i)=='T' && f==false){
                    k--;
                }
            while(k<0 && j<=i){
                if(s.charAt(j)=='T' && f==false){
                    k++;
                }else if(s.charAt(j)=='F' && f==true){
                    k++;
                }
                j++;
            }
            max=Math.max(max,i-j+1);
            i++;
        }
        return max;
    }
    
    
    
    //binary search on finding if can we find m length consecutive T/F
    /*
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
    // m length window possible within k or not
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
    */
}