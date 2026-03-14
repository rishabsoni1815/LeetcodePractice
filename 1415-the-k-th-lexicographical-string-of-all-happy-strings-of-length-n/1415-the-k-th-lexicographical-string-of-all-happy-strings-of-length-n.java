class Solution {
    int k=0;
    String ans="";
    public String getHappyString(int n, int kk) {
        k=kk;
        ans="";
        help(n-1,"a");
        help(n-1,"b");
        help(n-1,"c");   
        return ans;
    }
    void help(int n,String s){
        if(ans.length()>0) return;
        if(n==0){
            k--;
            if(k==0) ans=s;
            return; 
        }
        if(s.charAt(s.length()-1)=='a'){ 
            help(n-1,s+"b");
            help(n-1,s+"c");
        }else if(s.charAt(s.length()-1)=='b'){
            help(n-1,s+"a");
            help(n-1,s+"c");
        }else{
            help(n-1,s+"a");
            help(n-1,s+"b");
        }
    }
}