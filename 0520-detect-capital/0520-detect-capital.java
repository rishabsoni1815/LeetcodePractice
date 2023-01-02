class Solution {
    public boolean detectCapitalUse(String s) {
        int n=s.length();
        if(n==1) return true;
        if(s.charAt(0)>='A'&&s.charAt(0)<='Z'){
            int c=1;
            for(int i=1;i<n;i++){
                 if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                      c++;
                  }               
            }
            if(c!=1 && c<n){
                return false;
            } 
        }else{
            for(int i=1;i<n;i++){
                 if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                      return false;
                  }               
            }
        }
        return true;
    }
}